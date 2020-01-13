package cn.ekgc.itrip.hotel.transport;

import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.SearchDetailsHotelVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * <b>酒店借楼层</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/hotel")
public interface HotelTransport {
	/**
	 * <b>根据是否是国内查询热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotcity",method = RequestMethod.POST)
	List<AreaDic> queryHotCityByIsChina(@RequestParam Integer isChina)throws Exception;

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
	List<LabelDic> queryHotelFeature() throws Exception;
	/***
	 * <b>查询商圈</b>
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value = "/querytradearea",method = RequestMethod.POST)
	List<AreaDic> querytradearea(@RequestParam long cityId)throws Exception;
	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHotelVideoDescByHotelId",method = RequestMethod.POST)
	Hotel queryHotelVideoDescByHotelId(Long hotelId)throws Exception;


	/***
	 * <b>酒店详情</b>
	 * @author kanghu
	 * @version 4.0.0
	 * @since 4.0.0
	 * @return
	 */
	@RequestMapping(value = "/queryhoteldetails/{hotelId}",method = RequestMethod.POST)
	List<SearchDetailsHotelVO> queryhoteldetails(@RequestParam Long hotelId)throws Exception;
	/**
	 * <B>根据酒店Id查询政策</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelpolicy/{id}",method = RequestMethod.GET)
	Hotel queryhotelpolicy(@RequestParam long id)throws Exception;


	/**
	 * <B>根据酒店Id查询设施</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfacilities/{id}",method = RequestMethod.POST)
	Hotel queryhotelfacilities(@RequestParam Long id)throws Exception;
	/**
	 * <b>根据targetId查询酒店房型图片(type=3)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getImgByTargetIdAndTypeId", method = RequestMethod.POST)
	List<HotelImage> getTypeId(@RequestParam Long targetId)throws Exception;
}
