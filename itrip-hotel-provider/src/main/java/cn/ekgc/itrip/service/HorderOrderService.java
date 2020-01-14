package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.vo.*;

import java.util.List;
import java.util.Map;

/**
 * <b>验证房屋库存是否存足业务层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
public interface HorderOrderService {
	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	RoomStoreVO getpreorderinfo(ValidateRoomStoreVO validateRoomStoreVO)throws Exception;
	/**
	 * <b>新增酒店订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> addHotelOrder(HotelOrderAddVO hotelOrderAddVO)throws Exception;
	/**
	 * <b> 根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	List<HotelOrder> getPersonalOrderInfo(Long orderId)throws Exception;
	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	PersonalOrderRoomVO getpersonalorderroominfo(Long orderId)throws Exception;
	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	ModifyHotelOrderVO queryOrderById(Long orderId)throws Exception;
	/***
	 * <B>根据个人订单列表，并分页显示</B>
	 * @return
	 */
	Page<HotelOrder> getpersonalorderlist(ItripSearchOrderVO vo, Long id)throws Exception;

	HotelOrder getHotelOrderByNo(String orderNo)throws Exception;
}
