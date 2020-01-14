package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.User;

/**
 * <b>用户子项目业务接口</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
public interface UserService {
	/**
	 * <b>校验是否可以注册使用</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	boolean checkUserCodeForRegistry(String userCode) throws Exception;

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean registryUser(User user) throws Exception;

	/**
	 * <b>用户进行账户激活</b>
	 * @param userCode
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	boolean activateUser(String userCode, String activeCode) throws Exception;
	/**
	 * <b>使用userCode和userPassword进行登录</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	User getUserForLogin(String userCode, String userPassword)throws Exception;


	User getUserByUserCode(String userCode)throws Exception;
}
