package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.comment.transport.CommentTransport;
import cn.ekgc.itrip.hotel.transport.HotelOrderTransport;
import cn.ekgc.itrip.hotel.transport.HotelRoomTransport;
import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelImage;
import cn.ekgc.itrip.pojo.entity.ScoreComment;
import cn.ekgc.itrip.pojo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <b>评论控制层<b/>
 */
@RestController("commentController")
@RequestMapping(value = "biz/api/comment")
public class CommentController extends BaseController {
	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Autowired
	private CommentTransport commentTransport;
	@Autowired
	private HotelRoomTransport hotelRoomTransport;
	@RequestMapping(value = "/getcommentlist", method = RequestMethod.POST)
	public ResponseResult<Object> getCommentListByPage(@RequestBody SearchCommentVO queryVO) throws Exception {
		// 使用数据持久层查询分页信息
		Page<Comment> page = commentTransport.getCommentListByPage(queryVO);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, page);
	}
	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "gethotelscore/{hotelId}",method = RequestMethod.GET)
	public ResponseResult<Object> getHotelScore(@PathVariable("hotelId") Long hotelId) throws Exception {
		ScoreComment scoreComment=commentTransport.getHotelScore(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,scoreComment);
	}
	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcount/{hotelId}", method = RequestMethod.GET)
	public ResponseResult<Object>getcount(@PathVariable("hotelId") Long hotelId) throws Exception {
		CommentCountVO commentCountVO=commentTransport.getcount(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,commentCountVO);
	}
	/**
	 * <b>根据targetId查询评论照片(type=2)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	/**
	 * <b>根据targetId查询评论照片(type=2)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getimg/{targetId}", method = RequestMethod.GET)
	public ResponseResult<Object> getImgByTargetId(@PathVariable("targetId") Long targetId) throws Exception {
		List<HotelImage> hotelImageList = hotelRoomTransport.getImgByTargetIdAndTypeId(targetId, "2");
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, hotelImageList);
	}
	/***
	 * <b>获取酒店相关信息</b>
	 */
	@RequestMapping(value = "/gethoteldesc/{hotelId}",method = RequestMethod.GET)
	public ResponseResult<Object>gethoteldesc(@PathVariable("hotelId") Long hotelId)throws Exception{
		ItripHotelDescVO itripHotelDescVO= commentTransport.gethoteldesc(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,itripHotelDescVO);

	}

	/**
	 * <b>酒店类型</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gettraveltype",method = RequestMethod.GET)
	public ResponseResult<Object>gettraveltype(@RequestBody ItripLabelDicVO vo)throws Exception{
		List<Hotel> voList=commentTransport.gettraveltype(vo);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,vo);
	}
}