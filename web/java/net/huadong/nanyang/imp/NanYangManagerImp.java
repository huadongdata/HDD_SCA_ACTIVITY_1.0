package net.huadong.nanyang.imp;

import com.dstz.bpm.api.engine.action.cmd.ActionCmd;
import net.huadong.nanyang.NanYangManager;
import net.huadong.util.HttpUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohongwei on 2018/12/19.
 */
@Service("nanYangManagerImp")
public class NanYangManagerImp implements NanYangManager {
    @Override
    public void oilApply(ActionCmd actionCmd) {
        System.out.println("[加油申请书]流程调用成功");
    }

    /**
     * 审批最后的节点同意后，回调业务系统
     *
     * @param actionCmd
     * @param url
     */
    @Override
    public void doActionEnd(ActionCmd actionCmd, String url) throws Exception {
        String businessKey = actionCmd.getBusinessKey();//业务主键ID
        String actionName = actionCmd.getActionName();//同意:agree ;  拒绝:reject

        if ("agree".equals(actionName)) {
            Map<String, String> params = new HashMap<>();
            params.put("businessKey", businessKey);

            String result = HttpUtils.post(url, params);
//            "activityCallBack/oilapplication"

            if (!result.equals("success")) {
                throw new Exception(result);
            }

            System.out.println("流程审核完成");
        }
    }
}
