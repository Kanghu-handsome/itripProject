package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.HotelRoom;
import cn.ekgc.itrip.pojo.vo.HotelRoomVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>酒店房间数据持久层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface HotelRoomDao {
	/**
	 * <b>根据查询条件查询酒店房间列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<HotelRoom> findHotelRoomListByQuery(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>根据targetId和typeId获得酒店图片列表</b>
	 * @return
	 */
	List<HotelImage> findHotelImageListByQuery(Map<String, Object> queryMap)throws Exception;

	Integer findTotalRoomStore(Long roomId)throws Exception;
}
