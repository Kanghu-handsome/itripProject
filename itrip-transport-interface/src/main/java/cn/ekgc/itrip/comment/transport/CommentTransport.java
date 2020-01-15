package cn.ekgc.itrip.comment.transport;

import cn.ekgc.itrip.pojo.entity.*;
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
	/**
	 * <b>查询出游类型列表</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gettraveltype",method = RequestMethod.POST)
	List<LabelDic> gettraveltype()throws Exception;



	/***
	 * <b>新增评论<b/>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	boolean Add(@RequestBody ItripAddCommentVO vo,@RequestParam Long userId )throws Exception;
}
