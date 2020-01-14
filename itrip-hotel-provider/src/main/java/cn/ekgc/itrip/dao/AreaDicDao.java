package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.AreaDic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * <b>区域字典数据持久层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface AreaDicDao {
	/**
	 * <b>根据条件查询区域列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<AreaDic> findAreaDicListByQuery(Map<String, Object> queryMap)throws Exception;
}
