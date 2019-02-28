package net.huadong.nanyang;

import com.dstz.bpm.api.engine.action.cmd.ActionCmd;

/**
 * Created by zhaohongwei on 2018/12/18.
 */
public interface NanYangManager {
    public void oilApply(ActionCmd actionCmd);

    public void doActionEnd(ActionCmd actionCmd, String url) throws Exception;
}
