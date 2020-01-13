package cn.ekgc.itrip.transportImpl;

import cn.ekgc.itrip.comment.transport.CommentTransport;
import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.ScoreComment;
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
	/***
	 * <b>获取酒店相关信息</b>
	 */
	@RequestMapping(value = "/gethoteldesc",method = RequestMethod.POST)
	public ItripHotelDescVO gethoteldesc(@RequestParam Long hotelId)throws Exception{
		return commentService.gethoteldesc(hotelId);
	}
	/**
	 * <b>酒店类型</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gettraveltype",method = RequestMethod.POST)
	public List<Hotel> gettraveltype(@RequestBody ItripLabelDicVO vo)throws Exception{
		return commentService.gettraveltype(vo);
	}
}
