package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.*;
import cn.ekgc.itrip.pojo.vo.*;

import java.util.List;


public interface CommentService {
	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	Page<Comment> getCommentListByPage(SearchCommentVO queryVO) throws Exception;
	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	ScoreComment getHotelScore(Long hotelId)throws Exception;
	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	CommentCountVO getcount(Long hotelId)throws Exception;
	/**
	 * <b>查询出游类型列表</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> gettraveltype()throws Exception;
	/***
	 * <b>新增评论<b/>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean Add(ItripAddCommentVO vo, Long userId)throws Exception;
}
