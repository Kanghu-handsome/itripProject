package cn.ekgc.itrip.transportImpl;

import cn.ekgc.itrip.hotel.transport.HotelOrderTransport;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.vo.*;
import cn.ekgc.itrip.service.HorderOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <b>验证房屋库存是否存足传输层接口实现类</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelOrderTransport")
@RequestMapping("/hotelOrder")
public class HotelOrderTransportImpl implements HotelOrderTransport {
	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@Autowired
	private HorderOrderService horderOrderService;
	@RequestMapping(value = "/getpreorderinfo",method = RequestMethod.POST)
	public RoomStoreVO getpreorderinfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO)throws Exception{
		return horderOrderService.getpreorderinfo(validateRoomStoreVO);
	}
	/**
	 * <b>新增酒店订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addhotelorder", method = RequestMethod.POST)
	public Map<String, Object> addHotelOrder(@RequestBody HotelOrderAddVO hotelOrderAddVO)throws Exception{
		return horderOrderService.addHotelOrder(hotelOrderAddVO);
	}
	/**
	 * <b> 根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderinfo",method = RequestMethod.POST)
	public List<HotelOrder> getPersonalOrderInfo(@RequestParam Long orderId)throws Exception{
		return horderOrderService.getPersonalOrderInfo(orderId);
	}
	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderroominfo",method = RequestMethod.POST)
	public PersonalOrderRoomVO getpersonalorderroominfo(@RequestParam Long orderId)throws Exception{
		return horderOrderService.getpersonalorderroominfo(orderId);
	}
	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryOrderById",method = RequestMethod.POST)
	public ModifyHotelOrderVO queryOrderById(@RequestParam Long orderId)throws Exception{
		return horderOrderService.queryOrderById(orderId);
	}
	/***
	 * <B>根据个人订单列表，并分页显示</B>
	 * @return
	 */
	@RequestMapping(value = "/getpersonalorderlist",method = RequestMethod.POST)
	public Page<HotelOrder> getpersonalorderlist(@RequestBody ItripSearchOrderVO vo, @RequestParam Long id)throws Exception{
		return horderOrderService.getpersonalorderlist(vo,id);
	}
	@RequestMapping(value = "/queryOrderByNo", method = RequestMethod.POST)
	public HotelOrder getHotelOrderByNo(@RequestParam String orderNo)throws Exception {
		return horderOrderService.getHotelOrderByNo(orderNo);
	}

}
