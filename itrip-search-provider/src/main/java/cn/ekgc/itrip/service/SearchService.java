package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.vo.ItripHotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
/**
 * <b>搜索项目业务层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
public interface SearchService {

	/**
	 * <b>根据热门城市搜索视图查询酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	List<ItripHotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO)throws Exception;
}
