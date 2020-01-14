package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.vo.SearchDetailsHotelVO;

import java.util.List;

/**
 * <b>酒店业务层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
public interface HotelService {
	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */

	Hotel queryHotelVideoDescByHotelId(Long hotelId)throws Exception;
	/***
	 * <b>酒店详情</b>
	 * @author kanghu
	 * @version 4.0.0
	 * @since 4.0.0
	 * @return
	 */
	List<SearchDetailsHotelVO> queryhoteldetails(Long hotelId)throws Exception;
	/**
	 * <B>根据酒店Id查询政策</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Hotel queryhotelpolicy(long id)throws Exception;


	/**
	 * <B>根据酒店Id查询设施</B>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Hotel queryhotelfacilities(Long id)throws Exception;
	/**
	 * <b>根据targetId查询酒店房型图片(type=1)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	List<HotelImage> getTypeId(Long targetId)throws Exception;
}
