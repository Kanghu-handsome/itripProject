package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.ResponseResult;
import cn.ekgc.itrip.user.transport.UserTransport;
import cn.ekgc.itrip.util.ConstantUtil;
import cn.ekgc.itrip.util.JWTUtil;
import cn.ekgc.itrip.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>用户认证控制器</b>
 * @author kanghu
 * @version 4.0.0
 * @since 4.0.0
 */
@Api(value = "用户认证控制，集中完成用户的登陆和注册相关操作")
@RestController("authController")
@RequestMapping("/auth/api")
public class AuthController extends BaseController {
	@Autowired
	private UserTransport userTransport;
	private static final String emailRegEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	@ApiOperation(value = "校验用户注册所提供的Email地址是否可用")
	@RequestMapping(value = "/ckusr", method = RequestMethod.GET)
	public ResponseResult<User> checkEmailForRegistry(String name) throws Exception {
		// 校验用户所给定的email是否被占用
		boolean flag = userTransport.checkUserCodeForRegistry(name);
		if (flag) {
			// 校验正确，返回正确的数据
			return new ResponseResult<User>(SuccessEnum.SUCCESS_TRUE);
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "该Email地址不可用");
		}
	}

	/**
	 * <b>根据用户所提供的注册信息（email）完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doregister", method = RequestMethod.POST)
	public ResponseResult<User> checkUserCodeForRegistry(@RequestBody User user) throws Exception {
		boolean flag = userTransport.registryUser(user);

		if (flag) {
			return new ResponseResult<User>(SuccessEnum.SUCCESS_TRUE);
		} else {
			return new ResponseResult<User>(SuccessEnum.SUCCESS_FALSE, "注册失败，请稍后再试");
		}
	}
	/**
	 * <B>使用激活码激活用户账号</B>
	 * @author kanghu
	 * @version 4.0.0
	 * @since 4.0.0
	 */
	@RequestMapping(value = "/activate", method = RequestMethod.PUT)
	public ResponseResult<User> activateUser(String user, String code) throws Exception {
		// 校验用户所填写的email地址和校验码是否为null
		if (user != null && !"".equals(user.trim()) && code != null && !"".equals(code.trim())) {
			// 此时的email和code都是不为null的
			// 校验电子邮件是否正确
			if (user.matches(emailRegEx)) {
				// 电子邮件格式正确
				// 进行激活的
				if (userTransport.activateUser(user, code)) {
					return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
				} else {
					return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "激活失败，请联系管理员");
				}
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写正确的电子邮件地址");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写电子邮件和激活码");
		}
	}
	/**
	 * <b>根据用户所提供的注册信息（cellphone）完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registerbyphone", method = RequestMethod.POST)
	public ResponseResult<User> registryUserByCellphone(@RequestBody User user) throws Exception {
		// 校验用户所填写信息是否正确
		if (user.getUserCode() != null && !"".equals(user.getUserCode().trim())
				&& user.getUserPassword() != null && !"".equals(user.getUserPassword().trim())) {
			if (user.getUserCode().matches(ConstantUtil.REGEX_CELLPHONE)) {
				if (userTransport.checkUserCodeForRegistry(user.getUserCode())) {
					// 对于密码进行MDK5加密
					user.setUserPassword(MD5Util.encrypt(user.getUserPassword()));
					if (userTransport.registryUser(user)) {
						return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
					} else {
						return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "注册失败，请稍后再试");
					}
				} else {
					return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "该手机号码已被注册");
				}
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请正确填写手机号码");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写手机号码和登录密码");
		}
	}
	/**
	 * <b>激活使用手机注册用户</b>
	 * @param user
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/validatephone",method = RequestMethod.PUT)
	public ResponseResult<User>activateUserForCellphone(String user,String code) throws Exception {
		//校验用户所填写的是否正确
		if (user !=null && !"".equals(user.trim() ) && code !=null && !"".equals(code.trim())){
			//校验手机号是否正确
			if (user.matches(ConstantUtil.REGEX_CELLPHONE)){
					//进行激活
				if (userTransport.activateUser(user,code)){
					return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
				}else {
					return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"请联系管理员");
				}
			}else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"请填写正确的手机号码");
			}
		}else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"请填写正确的手机号码或短信验证码");
		}
	}
	/**
	 * <b>用户登录</b>
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dologin",method = RequestMethod.POST)
	public ResponseResult<User>loginUser(String name,String password) throws Exception {
		// 校验用户所提交的信息有效
		if (name != null && !"".equals(name.trim()) && password != null && !"".equals(password.trim())) {
			// 提交的信息有效，对于密码进行加密
			password = MD5Util.encrypt(password);
			// 进行用户登录
			User user = userTransport.getUserForLogin(name, password);
			if (user != null) {
				// 登陆成功
				// 绑定到Token中
				String token = JWTUtil.createToken(user.getId());
				response.setHeader("Authorization", token);
				return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, user);
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "登陆失败，请稍后再试");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写手机号码或电子邮件以及登陆密码");
		}
	}
}