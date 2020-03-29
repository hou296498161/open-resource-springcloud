package base;

import lombok.Getter;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 14:34
 */
public enum RespondEnum {

    /**
     * 200-成功
     */
    SUCCESS(200, "success"),
    /**
     * 10000-失败
     */
    FAILURE(10000, "失败"),

    SYSTEM_ERROR(500, "系统错误"),
    /**
     * 10001-参数为空
     */
    PARAMETER_NULL(10001, "参数验证错误"),
    /**
     * 10002-结果为空
     */
    LOGIN_INVALID(20000, "登陆失效"),
    ;

    @Getter
    private int code;
    @Getter
    private String message;

    private RespondEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
