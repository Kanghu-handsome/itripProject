package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>用户子项目数据持久层接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
/**
 * <b>根据查询条件查询用户信息列表</b>
 * @param queryMap
 * @return
 * @throws Exception
 */
public interface UserDao {
	List<User> findUserListByQuery(Map<String, Object> queryMap)throws Exception;
	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @throws Exception
	 */
	void saveUser(User user)throws Exception;
	/**
	 * <b>更新用户信息</b>
	 * @param user
	 * @throws Exception
	 */
	void updateUser(User user)throws Exception;


}
