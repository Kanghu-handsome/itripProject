package cn.ekgc.itrip.search.transport;

import cn.ekgc.itrip.pojo.vo.ItripHotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import javafx.geometry.Pos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * <b>搜索项目传输层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-search-provider")
@RequestMapping("/search")
public interface SearchInterface {
	/**
	 * <b>根据热门城市搜索视图查询酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchItripHotelListByHotCity",method = RequestMethod.POST)
	List<ItripHotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO)throws Exception;
}
