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
    ORDER_PLANTED_ERROR(307, "订单已分配 无需再分配"),

    FILE_ERROR_TYPE(401, "文件格式不正确"),
    FILE_UPLOAD_ERROR(402, "文件上传失败"),
    FILE_UPLOAD_ERR_SIZE(403, "文件大小超过2M"),

    CODE_UTF8_ERROR(501, "上传文件编码格式非UTF8"),
    AREA_NOT_ZREO(503, "面积不能小于等于0"),
    DAN_WEI_NAME(504, "该单位已被录入请检查（单位名称已被占用）"),
    YU_BAO_JIA_IS_HAVE(505, "此项目报价已添加，请勿重复添加"),

    SYSTEM_ERROR(900, "系统错误"),

    SERVICE_TIMEOUT(901, "依赖后端接口超时"),
    PROJECT_IS_NULL_ERROR(506, "项目不存在"),
    PROJECT_KAIPIAO_MONEY(507, "开票金额有误"),
    PROJECT_NEED_KAIPIAO_ERROR(508, "项目金额已全部开票"),

    SERVICE_RETURN_NULL(902, "依赖后端接口未返回"),
    LOCK_FAIL(903, "加锁失败"),
    OLD_PASSWORD_ERROR(1001, "旧密码错误"),
    NO_HAVE_ORDER_AUTH(1012, "对此订单无审核权限"),
    MESSAGE_NOT_UPDATE(1000, "信息未更新"),
    TECH_IS_ADD(1002, "订单技术卡已添加完成，无需添加"),
    ORDER_IS_NULL(1001, "订单查询不存在"),
    ORDER_IS_NOT_PLAN(1004, "订单状态不为已分配"),
    ORDER_IS_HAVE_ARE(1005, "订单已有面积结算，不可回退"),
    ORDER_IS_JINGFENG(1006, "订单已完成精封，不可再进行精封"),
    ORDER_IS_PLAN(1003, "订单已完成分配，不可更改纹理");



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
