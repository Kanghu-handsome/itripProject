package cn.ekgc.itrip.transportImpl;

import cn.ekgc.itrip.hotel.transport.UserInfoTransport;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.ItripAddUserLinkUserVO;
import cn.ekgc.itrip.pojo.vo.ItripModifyUserLinkUserVO;
import cn.ekgc.itrip.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController("userInfoTransport")
@RequestMapping("/userinfo")
public class UserInfoTransportImpl implements UserInfoTransport {
	@Autowired
	private UserInfoService userInfoService;
	/***
	 * <B>查询联系人</B>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getLinkUserListByLogin",method = RequestMethod.POST)
	public List<UserLinkUser> getLinkUserListByLogin(@RequestParam String userCode)throws Exception{
		return userInfoService.getLinkUserListByLogin(userCode);
	}
	/***
	 * <b>删除联系人</b>
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deluserlinkuser",method = RequestMethod.POST)
	public boolean deluserlinkuser(@RequestParam Long ids)throws Exception{
		return userInfoService.deluserlinkuser(ids);
	}
	/**
	 * <b>新增联系人</b>
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/adduserlinkuser",method = RequestMethod.POST)
	public boolean adduserlinkuser(@RequestBody ItripAddUserLinkUserVO vo, @RequestParam Long userId) throws Exception {
		return userInfoService.adduserlinkuser(vo,userId);
	}
	/**
	 * <b>修改联系人</b>
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/modifyuserlinkuser",method = RequestMethod.POST)
	public boolean modifyuserlinkuser(@RequestBody ItripModifyUserLinkUserVO vo,@RequestParam Long userId)throws Exception{
		return userInfoService.modifyuserlinkuser(vo,userId);
	}

}
