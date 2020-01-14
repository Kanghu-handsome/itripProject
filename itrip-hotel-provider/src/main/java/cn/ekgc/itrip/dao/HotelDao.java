package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.HotelRoom;
import cn.ekgc.itrip.pojo.entity.ItripHotel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface HotelDao {
	List<Hotel> findHotelListByQuery(Map<String, Object> queryMap)throws Exception;
	/**
	 * <b>根据查询条件查询订单列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<HotelRoom> findOrderListByQuery(Map<String, Object> queryMap)throws Exception;
}
