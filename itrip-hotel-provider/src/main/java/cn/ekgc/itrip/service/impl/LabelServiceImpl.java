package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.LabelDicDao;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <b>系统字典业务层接口实现类</b>
 * @author kanghu
 * @since 4.0.0
 * @version 4.0.0
 */
@Service("labelService")
@Transactional
public class LabelServiceImpl implements LabelService {
	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@Autowired
	private LabelDicDao labelDicDao;

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> queryHotelFeature() throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("parentId", 16);
		List<LabelDic> labelDicList = labelDicDao.findLabelDicListByQuery(queryMap);
		return labelDicList;
	}

	/**
	 * <b>查询酒店床型</b>
	 * @param
	 * @return
	 * @throws Exception
	 */

	public List<LabelDic> queryhotelroombed() throws Exception {
		Map<String,Object>queryMap=new HashMap<String, Object>();
		queryMap.put("parentId", 1);
		List<LabelDic>labelDicList=labelDicDao.findLabelDicListByQuery(queryMap);
		return labelDicList;
	}


}
