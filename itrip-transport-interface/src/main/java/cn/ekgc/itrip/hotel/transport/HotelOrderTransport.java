package cn.ekgc.itrip.hotel.transport;

import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <b>验证房屋库存是否存足传输层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/hotelOrder")
public interface HotelOrderTransport {
	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpreorderinfo",method = RequestMethod.POST)
	RoomStoreVO getpreorderinfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO)throws Exception;
	/**
	 * <b>新增酒店订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addhotelorder", method = RequestMethod.POST)
	Map<String, Object> addHotelOrder(@RequestBody HotelOrderAddVO hotelOrderAddVO)throws Exception;
	/**
	 * <b> 根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderinfo",method = RequestMethod.POST)
	List<HotelOrder> getPersonalOrderInfo(@RequestParam Long orderId) throws Exception;
	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderroominfo",method = RequestMethod.POST)
	PersonalOrderRoomVO getpersonalorderroominfo(@RequestParam Long orderId)throws Exception;
	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryOrderById",method = RequestMethod.POST)
	ModifyHotelOrderVO queryOrderById(@RequestParam Long orderId)throws Exception;
	/***
	 * <B>根据个人订单列表，并分页显示</B>
	 * @return
	 */
	@RequestMapping(value = "/getpersonalorderlist",method = RequestMethod.POST)
	Page<HotelOrder> getpersonalorderlist(@RequestBody ItripSearchOrderVO vo, @RequestParam Long id)throws Exception;

	@RequestMapping(value = "/queryOrderByNo", method = RequestMethod.POST)
	HotelOrder getHotelOrderByNo(@RequestParam String orderNo)throws Exception;

}
