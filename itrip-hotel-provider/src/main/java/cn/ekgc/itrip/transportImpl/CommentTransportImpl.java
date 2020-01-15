package cn.ekgc.itrip.transportImpl;

import cn.ekgc.itrip.comment.transport.CommentTransport;
import cn.ekgc.itrip.pojo.entity.*;
import cn.ekgc.itrip.pojo.vo.*;
import cn.ekgc.itrip.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("commentTransport")
@RequestMapping("/comment")
public class CommentTransportImpl implements CommentTransport {
	@Autowired
	private CommentService commentService;
	@RequestMapping(value = "/getcommentlist",method = RequestMethod.POST)
	public Page<Comment> getCommentListByPage(@RequestBody SearchCommentVO queryVO)throws Exception{
		return commentService.getCommentListByPage(queryVO);
	}
	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gethotelscore",method = RequestMethod.POST)
	public ScoreComment getHotelScore(@RequestParam Long hotelId)throws Exception{
		return commentService.getHotelScore(hotelId);
	}

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcount/{hotelId}",method = RequestMethod.POST)
	public CommentCountVO getcount(@RequestParam Long hotelId) throws Exception {
		return commentService.getcount(hotelId);
	}
	/**
	 * <b>查询出游类型列表</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gettraveltype",method = RequestMethod.POST)
	public List<LabelDic> gettraveltype()throws Exception{
		return commentService.gettraveltype();
	}



	/***
	 * <b>新增评论<b/>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public boolean Add(@RequestBody ItripAddCommentVO vo,@RequestParam Long userId) throws Exception {
		return commentService.Add(vo,userId);
	}
}
