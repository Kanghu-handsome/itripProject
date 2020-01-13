package cn.ekgc.itrip.user.transport;

import cn.ekgc.itrip.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
* <b>用户模块传输层接口</b>
* @author kanhu
* @version 4.0.0
* @since 4.0.0
*/
@FeignClient(name = "itrip-user-provider")
@RequestMapping("/user")
public interface UserTransport {
	/**
	 * <b>校验是否可以注册使用</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkUserCodeForRegistry", method = RequestMethod.POST)
	boolean checkUserCodeForRegistry(@RequestParam String userCode) throws Exception;

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registryUser", method = RequestMethod.POST)
	boolean registryUser(@RequestBody User user) throws Exception;

	/**
	 * <b>为使用电子邮件注册用户进行激活操作</b>
	 * @param userCode
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/activateUser", method = RequestMethod.POST)
	boolean activateUser(@RequestParam String userCode, @RequestParam String activeCode) throws Exception;
	/**
	 * <b>使用userCode和userPassword进行登录</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	User getUserForLogin(@RequestParam String userCode, @RequestParam String userPassword)throws Exception;



	@RequestMapping(value = "/userCode", method = RequestMethod.POST)
		User getUserByUserCode(@RequestParam String userCode)throws Exception;
}