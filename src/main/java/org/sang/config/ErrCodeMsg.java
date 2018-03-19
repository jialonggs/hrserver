package org.sang.config;

/**
 * @author 李正东
 * @date 2016-07-18
 * @email
 */
public enum ErrCodeMsg {
    SUCC(0, "成功"),
    COMMON_FAIL(107, "操作失败"),

    NOT_LOGIN(100, "未登录"),
    SELECT_NULL(108, "操作对象不存在"),
    EMAIL_PASS_NOT_MATCH(101, "用户名或密码错误"),
    ACCOUNT_NOT_BIND(102, "绑定账号异常或未绑定账号，请联系管理员"),
    TOKEN_INVALID(103, "token无效"),
    TOKEN_EXPIRED(104, "token过期"),
    TOKEN_NOT_RELEASE(105, "其他设备在登录未登出账号！"),
    ACCOUNT_BLACK_LISTED(106, "黑名单用户，请联系管理员"),

    // unchecked
    ARGS_MISSING(201, "参数不全"),
    ARGS_ILLEGAL(202, "非法参数"),
    SIGN_INCORRECT(203, "签名错误"),

    // checked
    NO_PERMISSION(301, "没有权限"),
    WORKFLOW_NOT_END(302, "审批流程尚未走完"),
    WORKFLOW_ENDING_NO_PERMISSION(303, "财务审核完成,无权限编辑"),
    TOO_FAST(304, "操作过快"),
    GOODS_SOLD_OUT(305, "商品售罄"),
    CANNOT_BUY(306, "商品不可购买"),

    FILE_ERROR_TYPE(401, "文件格式不正确"),
    FILE_UPLOAD_ERROR(402, "文件上传失败"),
    FILE_UPLOAD_ERR_SIZE(403, "文件大小超过2M"),

    CODE_UTF8_ERROR(501, "上传文件编码格式非UTF8"),

    SYSTEM_ERROR(900, "系统错误"),

    SERVICE_TIMEOUT(901, "依赖后端接口超时"),

    SERVICE_RETURN_NULL(902, "依赖后端接口未返回"),
    LOCK_FAIL(903, "加锁失败"),
    MESSAGE_NOT_UPDATE(1000, "信息未更新");

    private int code;
    private String msg;

    ErrCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 并发情况下 msg会被改写 不过算了
    public static ErrCodeMsg setCommonFail(String msg) {
        COMMON_FAIL.msg = msg;
        return COMMON_FAIL;
    }

    public static ErrCodeMsg codeOf(int code) {
        for (ErrCodeMsg msg : ErrCodeMsg.values()) {
            if (msg.getCode() == code) {
                return msg;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
