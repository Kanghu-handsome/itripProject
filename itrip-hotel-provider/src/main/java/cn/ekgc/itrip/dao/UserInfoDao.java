package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.ItripAddUserLinkUserVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserInfoDao {
	/***
	 * <B>查询联系人</B>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> findLinkUserListByQuery(Map<String, Object> queryMap)throws Exception;

	/***
	 * <b>删除联系人</b>
	 * @param ids
	 * @return
	 */
	boolean deluserlinkuser(Long ids)throws Exception;

	/**
	 * <b>新增联系人</b>
	 * @param
	 * @return
	 */
	void adduserlinkuser(UserLinkUser userLinkUser);
	/**
	 * <b>修改联系人</b>
	 * @param userLinkUser
	 * @return
	 */

	boolean modifyuserlinkuser(UserLinkUser userLinkUser)throws Exception;
}
