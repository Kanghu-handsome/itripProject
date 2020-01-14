package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.hotel.transport.HotelRoomTransport;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.HotelRoomVO;
import cn.ekgc.itrip.pojo.vo.ResponseResult;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>酒店房间控制器</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelRoomController")
@RequestMapping("/biz/api/hotelroom")
public class HotelRoomController extends BaseController {
	@Autowired
	private HotelRoomTransport hotelRoomTransport;

	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombyhotel", method = RequestMethod.POST)
	public ResponseResult<Object> queryHotelRoombyHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO)
			throws Exception {
		List<List<HotelRoomVO>> resultList = new ArrayList<List<HotelRoomVO>>();
		List<HotelRoomVO> hotelRoomVOList = hotelRoomTransport.queryHotelRoomByHotel(searchHotelRoomVO);
		for (HotelRoomVO hotelRoomVO : hotelRoomVOList) {
			List<HotelRoomVO> tempList = new ArrayList<HotelRoomVO>();
			tempList.add(hotelRoomVO);
			resultList.add(tempList);
		}
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, resultList);
	}
	/**
	 * <b>查询酒店床型</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombed",method = RequestMethod.GET)
	public ResponseResult<Object>queryhotelroombed()throws Exception{
		List<LabelDic> itripLabelDicVOList= hotelRoomTransport.queryhotelroombed();
		if (itripLabelDicVOList !=null && itripLabelDicVOList.size()>0){
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,itripLabelDicVOList);
		}
		return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"获取失败");
	}
	/**
	 * <b>根据targetId查询酒店房型图片(type=1)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getimg/{targetId}", method = RequestMethod.GET)
	public ResponseResult<Object> getImgByTargetId(@PathVariable("targetId") Long targetId) throws Exception {
		List<HotelImage> hotelImageList = hotelRoomTransport.getImgByTargetIdAndTypeId(targetId, "1");
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, hotelImageList);
	}


}
