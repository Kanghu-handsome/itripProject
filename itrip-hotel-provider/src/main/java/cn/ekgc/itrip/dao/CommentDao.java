package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.entity.ScoreComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CommentDao {
	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<Comment> findCommentByQuery(Map<String, Object> queryMap)throws Exception;

	ScoreComment findScoreCommentByHotelId(Long hotelId)throws Exception;
}
