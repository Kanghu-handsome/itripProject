package cn.ekgc.itrip.search.iransporyImpl;

import cn.ekgc.itrip.pojo.vo.ItripHotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.search.transport.SearchInterface;
import cn.ekgc.itrip.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("searchInterface")
@RequestMapping("/search")
public class SearchInterfaceImpl implements SearchInterface {
	/**
	 * <b>根据热门城市搜索视图查询酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@Autowired
	private SearchService searchService;
	@RequestMapping(value = "/searchItripHotelListByHotCity",method = RequestMethod.POST)
	public List<ItripHotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO)throws Exception{
		return searchService.searchItripHotelListByHotCity(searchHotCityVO);
	}
}
