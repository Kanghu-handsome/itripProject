package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.hotel.transport.HotelRoomTransport;
import cn.ekgc.itrip.hotel.transport.HotelTransport;
import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.ItripSearchDetailsHotelVO;
import cn.ekgc.itrip.pojo.vo.ItripSearchFacilitiesHotelVO;
import cn.ekgc.itrip.pojo.vo.ResponseResult;
import cn.ekgc.itrip.pojo.vo.SearchDetailsHotelVO;
import com.sun.mail.imap.protocol.ID;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>酒店控制层</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelController")
@RequestMapping("/biz/api/hotel")
public class HotelController extends BaseController {
	@Autowired
	private HotelTransport hotelTransport;
	/**
	 * <b>根据是否是国内查询热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotcity/{isChina}", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotCityByIsChina(@PathVariable("isChina") Integer isChina) throws Exception {
		List<AreaDic> areaDicList = hotelTransport.queryHotCityByIsChina(isChina);
		return new ResponseResult<Object>(SuccessEnum.SUCCESS_TRUE, areaDicList);
	}
	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotelFeature() throws Exception {
		List<LabelDic> labelDicList = hotelTransport.queryHotelFeature();
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, labelDicList);
	}

	/***
	 * <b>查询商圈</b>
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value = "/querytradearea/{cityId}",method = RequestMethod.GET)
	public ResponseResult<Object> querytradearea(@PathVariable("cityId") Long cityId)throws Exception {
		List<AreaDic> objectList=hotelTransport.querytradearea(cityId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,objectList);
	}
	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getvideodesc/{hotelId}", method = RequestMethod.GET)
	public ResponseResult<Object>getvideodesc(@PathVariable("hotelId") Long hotelId) throws Exception {
		Hotel hotel=hotelTransport.queryHotelVideoDescByHotelId(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,hotel);

	}
	/***
	 * <b>酒店详情</b>
	 * @author kanghu
	 * @version 4.0.0
	 * @since 4.0.0
	 */
	@RequestMapping(value = "/queryhoteldetails/{hotelId}",method = RequestMethod.GET)
	public ResponseResult<Object>queryhoteldetails(@PathVariable("hotelId")Long hotelId) throws Exception {
		List<SearchDetailsHotelVO> list=hotelTransport.queryhoteldetails(hotelId);
		if (list !=null && list.size()>0){
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,list);
		}
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"酒店id不能为空");
	}

	/**
	 * <B>根据酒店Id查询政策</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelpolicy/{id}",method = RequestMethod.GET)
	public ResponseResult<Object>queryhotelpolicy(@PathVariable("id") Long id)throws Exception{
		Hotel hotel=hotelTransport.queryhotelpolicy(id);
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,"", hotel.getHotelPolicy());
	}
	/**
	 * <B>根据酒店Id查询设施</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfacilities/{id}",method = RequestMethod.GET)
	public ResponseResult<Object>queryhotelfacilities(@PathVariable("id") Long id)throws Exception{
		Hotel hotel=hotelTransport.queryhotelfacilities(id);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,"",hotel.getFacilities());
	}
	/**
	 * <b>根据targetId查询酒店房型图片(type=3)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getimg/{targetId}", method = RequestMethod.GET)
	public ResponseResult<Object> getimg(@PathVariable("targetId") Long targetId) throws Exception {
		List<HotelImage> hotelImageList = hotelTransport.getTypeId(targetId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, hotelImageList);
	}


}
