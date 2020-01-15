package cn.ekgc.itrip.service.impl;
import cn.ekgc.itrip.dao.CommentDao;
import cn.ekgc.itrip.dao.HotelDao;
import cn.ekgc.itrip.dao.HotelOrderDao;
import cn.ekgc.itrip.dao.LabelDicDao;
import cn.ekgc.itrip.pojo.entity.*;
import cn.ekgc.itrip.pojo.vo.*;
import cn.ekgc.itrip.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InterfaceAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
@Transactional
public class CommontServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private LabelDicDao labelDicDao;
	@Autowired
	private HotelOrderDao hotelOrderDao;
	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	public Page<Comment> getCommentListByPage(SearchCommentVO queryVO) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("hotelId", queryVO.getHotelId());
		if (queryVO.getIsHavingImg() != -1) {
			queryMap.put("isHavingImg", queryVO.getIsHavingImg());
		}
		if (queryVO.getIsOk() != -1) {
			queryMap.put("isOk", queryVO.getIsOk());
		}
		queryMap.put("start", (queryVO.getPageNo() - 1) * queryVO.getPageSize());
		queryMap.put("size", queryVO.getPageSize());
		//获取分页列表
		List<Comment> commentList = commentDao.findCommentByQuery(queryMap);
		//获得总条数
		queryMap.remove("start");
		queryMap.remove("size");
		Integer total = commentDao.findCommentByQuery(queryMap).size();

		// 封装分页对象
		Page<Comment> page = new Page<Comment>(queryVO.getPageNo(), queryVO.getPageSize(), total);
		page.setRows(commentList);
		return page;
	}

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 *
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public ScoreComment getHotelScore(Long hotelId) throws Exception {
		return commentDao.findScoreCommentByHotelId(hotelId);
	}

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 *
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public CommentCountVO getcount(Long hotelId) throws Exception {
		CommentCountVO commentCountVO = new CommentCountVO();
		// 设定查询参数
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("hotelId", hotelId);
		// 查询总评论数
		commentCountVO.setAllcomment(commentDao.findCommentByQuery(queryMap).size());
		// 查询值得推荐
		queryMap.put("isOk", 1);
		commentCountVO.setIsok(commentDao.findCommentByQuery(queryMap).size());
		// 值得改善
		queryMap.put("isOk", 0);
		commentCountVO.setImprove(commentDao.findCommentByQuery(queryMap).size());
		// 有图片
		queryMap.remove("isOk");
		queryMap.put("isHavingImg", 1);
		commentCountVO.setHavingimg(commentDao.findCommentByQuery(queryMap).size());
		return commentCountVO;
	}


	/**
	 * <b>查询出游类型列表</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> gettraveltype() throws Exception {
		Map<String,Object>queryMap=new HashMap<String,Object>();
		queryMap.put("parentId", 107);
		List<LabelDic>labelDicList= labelDicDao.findLabelDicListByQuery(queryMap);
		return labelDicList;
	}

	/***
	 * <b>新增评论<b/>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean Add(ItripAddCommentVO vo, Long userId) throws Exception {
		Comment comment=new Comment();
		BeanUtils.copyProperties(vo, comment);
		comment.setUserId(userId);
		comment.setCreatedBy(userId);
		comment.setCreationDate(new Date());
		Integer score =(comment.getFacilitiesScore()+comment.getHygieneScore()+comment.getPositionScore()+comment.getServiceScore())/4;
		comment.setScore(score);
		//改变状态
		boolean flag=commentDao.add(comment);
			if (flag){
				HotelOrder hotelOrder=new HotelOrder();
				hotelOrder.setCreationDate(new Date());
				hotelOrder.setOrderStatus(4);
				hotelOrder.setId(vo.getOrderId());
				hotelOrder.setModifiedBy(userId);
				flag= hotelOrderDao.updateOrderStatus(hotelOrder);
				return flag;
			}
			return flag;
	}


}