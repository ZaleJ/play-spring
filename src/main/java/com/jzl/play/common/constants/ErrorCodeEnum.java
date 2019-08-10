package com.jzl.play.common.constants;


import com.jzl.play.common.entity.Result;

/**
 * 异常枚举类
 *
 * @author wangshun
 * @version 1.0
 * @since 2016/
 */
public enum ErrorCodeEnum {

    /**
     * 成功
     */
    SYS000("SYS000", "操作成功"),


    /**
     * 失败
     */
    SYS999("SYS999", "操作失败"),

    /*
     * 错误码在工程中出现次数必须全局唯一
     */

    /**
     * 错误信息设置begin
     */
    /**
     * 系统异常
     */
    SQL_0001("SQL_0001", "SQL语句错误，请联系管理员"),
    SYS_0001("SYS_0001", "服务器发生异常,请联系管理员"),
    SYS_0002("SYS_0002", "请求参数类型不匹配，请核查后重新操作"),
    SYS_0003("SYS_0003", "空指针异常，请联系管理员"),
    SYS_0004("SYS_0004", "获取用户权限失败，请确认是否开通权限"),
    SYS_0005("SYS_0005", "缺少必传参数，请核查后重新操作"),
    SYS_0006("SYS_0006", "该中心不存在"),
    SYS_0007("SYS_0007", "禁用启用参数不正确"),
    SYS_0008("SYS_0008", "远程RPC服务异常，请联系管理人员"),
    SYS_0009("SYS_0009", "中心编号不能为空"),
    SYS_0010("SYS_0010", "无数据权限，不允许访问"),
    SYS_0200("SYS_0200", "获取用户信息失败请重试"),
    SYS_0999("SYS_0999", "记录不存在"),

    /**
     * 通用push服务
     */
    MQCPUSH001("MQCPUSH001","参数输入错误"),

    ;

    /**
     * 错误编号
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    ErrorCodeEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    private void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return String.format(errorMessage, args);
    }

    public void generateError(Result<?> result) {
        result.setStatusCode(getErrorCode());
        result.setMessage(getErrorMessage());
    }

}
