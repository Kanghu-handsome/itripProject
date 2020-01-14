package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.pojo.vo.ItripHotelVO;
import cn.ekgc.itrip.pojo.vo.ResponseResult;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.search.transport.SearchInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <b>搜索模块控制器</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("searchController")
@RequestMapping(value = "search/api")
public class SearchController extends BaseController {
	/**
	 * <b>根据查询视图，查询搜索热门城市</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@Autowired
	private SearchInterface searchInterface;
	@RequestMapping(value = "/hotellist/searchItripHotelListByHotCity", method = RequestMethod.POST)
	public ResponseResult<Object>searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO)throws Exception{
			List<ItripHotelVO> itripHotelVOList = searchInterface.searchItripHotelListByHotCity(searchHotCityVO);
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, itripHotelVOList);
	}


}