package cn.ekgc.itrip.util;
/**
 * <b>订单编号生成规则工具类</b>
 */
public class OrderNoUtil {
	/**
	 * <b>生成唯一的酒店订单编号</b>
	 * <B>kanghu</B>
	 * <p>
	 *
	 *     MD5(当前时间毫秒数 + hotelId + Random + roomId)
	 * </p>
	 * @param hotelId
	 * @param roomId
	 * @return
	 */
	public static String createOrderNo(Long hotelId, Long roomId){
		StringBuffer sb=new StringBuffer();
		sb.append(hotelId);
		sb.append(roomId);
		sb.append(System.currentTimeMillis());
		sb.append(Math.round(Math.random()*1000));
		String orderNo=MD5Util.encrypt(sb.toString());
		return orderNo;
	}
}
