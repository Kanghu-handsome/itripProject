package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.vo.HotelRoomVO;
import cn.ekgc.itrip.pojo.vo.ItripLabelDicVO;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
/**
 * <b>酒店房间业务层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
public interface HotelRoomService {
	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	List<HotelRoomVO> queryHotelRoomByHotel(SearchHotelRoomVO searchHotelRoomVO) throws Exception;

	/**
	 * <b>根据targetId和typeId获得酒店图片列表</b>
	 * @param targetId
	 * @param typeId
	 * @return
	 */
	List<HotelImage> getImgByTargetIdAndTypeId(Long targetId, String typeId) throws Exception;
}

