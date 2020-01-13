package cn.ekgc.itrip.base.enums;
/**
 * <b>返回信息成功失败枚举类型</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
public enum  SuccessEnum {
	SUCCESS_TRUE("true"),
	SUCCESS_FALSE("false");
	private String msg;

	private SuccessEnum(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
