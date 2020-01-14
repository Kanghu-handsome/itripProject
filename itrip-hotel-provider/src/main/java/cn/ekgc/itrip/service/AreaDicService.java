package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.AreaDic;

import java.util.List;

public interface AreaDicService {
	/**
	 * <b>根据是否是中国查询对应的热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	List<AreaDic> queryHotCityByIsChina(Integer isChina)throws Exception;
	/***
	 * <b>查询商圈实现类</b>
	 * @param cityId
	 * @return
	 */
	List<AreaDic> querytradearea(long cityId)throws Exception;
}
