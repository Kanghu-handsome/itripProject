package cn.ekgc.itrip.transportImpl;

import cn.ekgc.itrip.hotel.transport.HotelRoomTransport;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.HotelRoomVO;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import cn.ekgc.itrip.service.HotelRoomService;
import cn.ekgc.itrip.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * <b>酒店房间项目传输层接口实现类</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelRoomTransport")
@RequestMapping("/hotelroom")
public class HotelRoomTransportImpl implements HotelRoomTransport {
	@Autowired
	private HotelRoomService hotelRoomService;
	@Autowired
	private LabelService labelService;

	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombyhotel", method = RequestMethod.POST)
	public List<HotelRoomVO> queryHotelRoomByHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO) throws Exception {
		return hotelRoomService.queryHotelRoomByHotel(searchHotelRoomVO);
	}
	/**
	 * <b>查询酒店床型</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombed",method = RequestMethod.POST)
	public List<LabelDic> queryhotelroombed() throws Exception {
		return labelService.queryhotelroombed();
	}
	/**
	 * <b>根据targetId和typeId获得酒店图片列表</b>
	 * @param targetId
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/getimg", method = RequestMethod.POST)
	public List<HotelImage> getImgByTargetIdAndTypeId(@RequestParam Long targetId, @RequestParam String typeId) throws Exception {
		return hotelRoomService.getImgByTargetIdAndTypeId(targetId, typeId);
	}
}

