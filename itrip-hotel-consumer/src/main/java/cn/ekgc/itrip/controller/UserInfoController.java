package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.hotel.transport.UserInfoTransport;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.ItripAddUserLinkUserVO;
import cn.ekgc.itrip.pojo.vo.ItripModifyUserLinkUserVO;
import cn.ekgc.itrip.pojo.vo.ResponseResult;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;
import cn.ekgc.itrip.user.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;

@RestController("userInfoController")
@RequestMapping("/biz/api/userinfo")
public class UserInfoController extends BaseController {
	@Autowired
	private UserInfoTransport userInfoTransport;
	@Autowired
	private UserTransport userTransport;

	/***
	 * <B>查询联系人</B>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryuserlinkuser",method = RequestMethod.POST)
	public ResponseResult<Object>queryuserlinkuser(@RequestBody ValidateRoomStoreVO vo)throws Exception{
		//获得所有的Cookie对象
		Cookie[] cookies = request.getCookies();
		String userCode="";
		for (Cookie coolie:cookies) {
			if (coolie.getName().equals("user")){
				userCode=coolie.getValue();
			}
		}
		//根据当前登录获得登陆常用联系人
		List<UserLinkUser>userLinkUserList=userInfoTransport.getLinkUserListByLogin(userCode);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,userLinkUserList);
	}


	/**
	 * <b>新增联系人</b>
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/adduserlinkuser",method = RequestMethod.POST)
	public ResponseResult<Object> adduserlinkuser(@RequestBody ItripAddUserLinkUserVO vo) throws Exception {
		//获得常用联系人
		Cookie[]cookies=request.getCookies();
		String userCode="";
		for (Cookie coolie:cookies) {
			if (coolie.getName().equals("user")){
				userCode=coolie.getValue();
			}
		}
		User user=userTransport.getUserByUserCode(userCode);
		boolean flag= userInfoTransport.adduserlinkuser(vo,user.getId());
			if (flag){
				return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
			}else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE);
			}


	}

	/***
	 * <b>删除联系人</b>
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deluserlinkuser",method = RequestMethod.GET)
	public ResponseResult<Object>deluserlinkuser(Long ids) throws Exception {
		//获得常用联系人
		Cookie[]cookies=request.getCookies();
		String userCode="";
		for (Cookie coolie:cookies) {
			if (coolie.getName().equals("user")){
				userCode=coolie.getValue();
			}
		}
		User user=userTransport.getUserByUserCode(userCode);
		boolean flag =userInfoTransport.deluserlinkuser(ids);
		if (flag){
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE,"不能删除");
		}else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE,"删除失败");
		}
	}

	/**
	 * <b>修改联系人</b>
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/modifyuserlinkuser",method = RequestMethod.POST)
	public ResponseResult<Object> modifyuserlinkuser(@RequestBody ItripModifyUserLinkUserVO vo) throws Exception {
		//获得常用联系人
		Cookie[]cookies=request.getCookies();
		String userCode="";
		for (Cookie coolie:cookies) {
			if (coolie.getName().equals("user")){
				userCode=coolie.getValue();
			}
		}
		User user=userTransport.getUserByUserCode(userCode);
		boolean flag=userInfoTransport.modifyuserlinkuser(vo,user.getId());
		if (flag){
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
		}else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE);
		}

	}
}
