package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.LabelDic;

import java.util.List;

/**
 * <b>系统字典业务层接口</b>
 * @author Arthur
 * @since 4.0.0
 * @version 4.0.0
 */
public interface LabelService {
	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> queryHotelFeature()throws Exception;
	/**
	 * <b>查询酒店床型</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> queryhotelroombed()throws Exception;
}
