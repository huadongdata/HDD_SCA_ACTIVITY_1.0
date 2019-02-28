package com.dstz.security.entity;

import com.alibaba.fastjson.JSONObject;
import com.dstz.form.api.model.FormCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaohongwei on 2018/12/14.
 */
@ApiModel(
        value = "流程 ActionCmd 请求参数",
        description = "流程实例、任务 ActionCmd 请求参数，请参考FlowRequestParam.java 或者文档了解 "
)
public class HddFlowRequestParam {
    @ApiModelProperty("流程定义id")
    private String defId;
    @ApiModelProperty("流程实例id")
    private String instanceId;
    @ApiModelProperty("流程任务id")
    private String taskId;
    @ApiModelProperty("action name")
    private String action;
    @ApiModelProperty("前端节点人员设置")
    private JSONObject nodeUsers;
    @ApiModelProperty("流程业务数据，JSON格式：{boCodeA:{},boCodeB:{}}")
    private JSONObject data;
    @ApiModelProperty("表单类型")
    private String formType;
    @ApiModelProperty("流程任务审批意见")
    private String opinion;
    @ApiModelProperty("目标节点")
    private String destination;
    @ApiModelProperty("特殊属性扩展配置：可以再 ActionCmd 中拿到此配置")
    private JSONObject extendConf;
    @ApiModelProperty("业务ID")
    private String bizKey;

    public HddFlowRequestParam(String taskId, String action, JSONObject data, String opinion, String bizKey) {
        this.formType = FormCategory.INNER.value();
        this.taskId = taskId;
        this.action = action;
        this.data = data;
        this.opinion = opinion;
        this.bizKey = bizKey;
    }

    public HddFlowRequestParam(String defId, String action, JSONObject data, String bizKey) {
        this.formType = FormCategory.INNER.value();
        this.defId = defId;
        this.action = action;
        this.data = data;
        this.bizKey = bizKey;
    }

    public HddFlowRequestParam() {
        this.formType = FormCategory.INNER.value();
    }

    public String getDefId() {
        return this.defId;
    }

    public void setDefId(String defId) {
        this.defId = defId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public JSONObject getNodeUsers() {
        return this.nodeUsers;
    }

    public void setNodeUsers(JSONObject nodeUsers) {
        this.nodeUsers = nodeUsers;
    }

    public JSONObject getData() {
        return this.data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getFormType() {
        return this.formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public JSONObject getExtendConf() {
        return this.extendConf;
    }

    public void setExtendConf(JSONObject extendConf) {
        this.extendConf = extendConf;
    }

    public String getBizKey() {
        return bizKey;
    }

    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }
}