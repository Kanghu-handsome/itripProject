package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.hotel.transport.HotelOrderTransport;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.*;
import cn.ekgc.itrip.user.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;

/**
 * <b>验证房屋库存是否存足控制层</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelOrder")
@RequestMapping("/biz/api/hotelorder")
public class HotelOrderController extends BaseController {
	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@Autowired
	private HotelOrderTransport hotelOrderTransport;
	@Autowired
	private UserTransport userTransport;
	@RequestMapping(value = "/getpreorderinfo",method = RequestMethod.POST)
	public ResponseResult<Object>getpreorderinfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		RoomStoreVO roomStoreVO=hotelOrderTransport.getpreorderinfo(validateRoomStoreVO);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,roomStoreVO);
	}

	/**
	 * <b>生成订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addhotelorder",method = RequestMethod.POST)
	public ResponseResult addhotelorder(@RequestBody HotelOrderAddVO hotelOrderAddVO)throws Exception{
		//判断是否有库存
		ValidateRoomStoreVO validateRoomStoreVO=new ValidateRoomStoreVO();
		validateRoomStoreVO.setCheckInDate(hotelOrderAddVO.getCheckInDate());
		validateRoomStoreVO.setCheckOutDate(hotelOrderAddVO.getCheckOutDate());
		validateRoomStoreVO.setCount(hotelOrderAddVO.getCount());
		validateRoomStoreVO.setHotelId(hotelOrderAddVO.getHotelId());
		validateRoomStoreVO.setRoomId(hotelOrderAddVO.getRoomId());
		RoomStoreVO roomStoreVO=hotelOrderTransport.getpreorderinfo(validateRoomStoreVO);
		Integer store=roomStoreVO.getStore();
		if (store !=null && store>=hotelOrderAddVO.getCount()) {
			//获得当前登录用户
			Cookie[] cookies = request.getCookies();
			String userCode = "";
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					userCode = cookie.getValue();
				}
			}
			// 酒店的数据满足
			// 开始进行入库操作
			// 获得当前登录用户主键
			User user = userTransport.getUserByUserCode(userCode);
			hotelOrderAddVO.setUserId(user.getId());
			Map<String, Object> resultMap = hotelOrderTransport.addHotelOrder(hotelOrderAddVO);
			if (resultMap != null) {
				return new ResponseResult(SuccessEnum.SUCCESS_TRUE, resultMap);
			} else {
				return new ResponseResult(SuccessEnum.SUCCESS_FALSE, "库存不足");
			}
		}
		return null;
	}

	/**
	 * <b> 根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderinfo/{orderId}",method = RequestMethod.GET)
	public ResponseResult getpersonalorderinfo(@PathVariable("orderId") Long orderId) throws Exception {
		List<HotelOrder>hotelOrderList=hotelOrderTransport.getPersonalOrderInfo(orderId);
		if (hotelOrderList !=null && hotelOrderList.size()>0){
			return new ResponseResult(SuccessEnum.SUCCESS_TRUE,hotelOrderList);
		}
		return new ResponseResult(SuccessEnum.SUCCESS_FALSE,"未获得到结果");
	}
	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderroominfo/{orderId}",method = RequestMethod.GET)
	public ResponseResult<Object>getpersonalorderroominfo(@PathVariable("orderId") Long orderId) throws Exception {
		PersonalOrderRoomVO personalOrderRoomVO=hotelOrderTransport.getpersonalorderroominfo(orderId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,personalOrderRoomVO);
	}
	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryOrderById/{orderId}",method = RequestMethod.GET)
	public ResponseResult<Object>queryOrderById(@PathVariable("orderId") Long orderId)throws Exception{
	ModifyHotelOrderVO modifyHotelOrderVO=hotelOrderTransport.queryOrderById(orderId);
	return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,orderId);
	}

	/***
	 * <B>根据个人订单列表，并分页显示</B>
	 * @return
	 */
	@RequestMapping(value = "/getpersonalorderlist",method = RequestMethod.POST)
	public ResponseResult<Object>getpersonalorderlist(@RequestBody ItripSearchOrderVO vo) throws Exception {
		//获得Cookies里面存放的值
		Cookie[] cookies=request.getCookies();
		String userCode="";
		//循环Cooies每一个对象
		for (Cookie cookie:cookies) {
			//判断cookie里面的一个k和value值是否匹配
			if (cookie.getName().equals("user")){
				userCode=cookie.getValue();


			}
		}

		//通过传递userCode参数得到user对象
		User user=userTransport.getUserByUserCode(userCode);
		Page<HotelOrder>page=hotelOrderTransport.getpersonalorderlist(vo,user.getId());
		if (page !=null){
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,page);
		}else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"没有可看的信息");
		}
	}

}

