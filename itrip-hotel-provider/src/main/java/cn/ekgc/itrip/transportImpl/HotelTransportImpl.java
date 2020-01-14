package cn.ekgc.itrip.transportImpl;

import cn.ekgc.itrip.hotel.transport.HotelTransport;
import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.SearchDetailsHotelVO;
import cn.ekgc.itrip.service.AreaDicService;
import cn.ekgc.itrip.service.HotelService;
import cn.ekgc.itrip.service.LabelService;
import com.sun.mail.imap.protocol.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("hotelTransport")
@RequestMapping("/hotel")
public class HotelTransportImpl implements HotelTransport {
	@Autowired
	private AreaDicService areaDicService;
	@Autowired
	private LabelService labelService;
	@Autowired
	private HotelService hotelService;

	/**
	 * <b>根据是否是中国查询对应的热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotcity",method = RequestMethod.POST)
	public List<AreaDic> queryHotCityByIsChina(@RequestParam Integer isChina) throws Exception {
		return areaDicService.queryHotCityByIsChina(isChina);
	}

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
	public List<LabelDic> queryHotelFeature() throws Exception {
		return labelService.queryHotelFeature();
	}



	/***
	 * <b>查询商圈</b>
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value = "/querytradearea",method = RequestMethod.POST)
	public List<AreaDic> querytradearea(@RequestParam long cityId)throws Exception{
		return areaDicService.querytradearea(cityId);
	}
	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHotelVideoDescByHotelId",method = RequestMethod.POST)
	public Hotel queryHotelVideoDescByHotelId(Long hotelId)throws Exception{
		return hotelService.queryHotelVideoDescByHotelId(hotelId);
	}
	/***
	 * <b>酒店详情</b>
	 * @author kanghu
	 * @version 4.0.0
	 * @since 4.0.0
	 * @return
	 */
	@RequestMapping(value = "/queryhoteldetails/{hotelId}",method = RequestMethod.POST)
	public List<SearchDetailsHotelVO> queryhoteldetails(@RequestParam Long hotelId)throws Exception{
		return hotelService.queryhoteldetails(hotelId);
	}
	/**
	 * <B>根据酒店Id查询政策</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelpolicy/{id}",method = RequestMethod.GET)
	public Hotel queryhotelpolicy(@RequestParam long id)throws Exception{
		return hotelService.queryhotelpolicy(id);
	}
	/**
	 * <B>根据酒店Id查询设施</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfacilities/{id}",method = RequestMethod.POST)
	public Hotel queryhotelfacilities(@RequestParam Long id)throws Exception{
		return hotelService.queryhotelfacilities(id);
	}


	/**
	 * <b>根据targetId查询酒店房型图片(type=1)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getImgByTargetIdAndTypeId", method = RequestMethod.POST)
	public List<HotelImage> getTypeId(@RequestParam Long targetId)throws Exception{
		return hotelService.getTypeId(targetId);
	}


}
