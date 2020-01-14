package cn.ekgc.itrip.comment.transport;

import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.ScoreComment;
import cn.ekgc.itrip.pojo.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>评论传输层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/comment")
public interface CommentTransport {
	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcommentlist", method = RequestMethod.POST)
	Page<Comment> getCommentListByPage(@RequestBody SearchCommentVO queryVO) throws Exception;
	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gethotelscore",method = RequestMethod.POST)
	ScoreComment getHotelScore(@RequestParam Long hotelId)throws Exception;
	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcount/{hotelId}",method = RequestMethod.POST)
	CommentCountVO getcount(@RequestParam Long hotelId)throws Exception;
	/***
	 * <b>获取酒店相关信息</b>
	 */
	@RequestMapping(value = "/gethoteldesc",method = RequestMethod.POST)
	ItripHotelDescVO gethoteldesc(@RequestParam Long hotelId)throws Exception;
	/**
	 * <b>酒店类型</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gettraveltype",method = RequestMethod.POST)
	List<Hotel> gettraveltype(@RequestBody ItripLabelDicVO vo)throws Exception;
}
