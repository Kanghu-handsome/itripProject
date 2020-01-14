package cn.ekgc.itrip.hotel.transport;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.ItripAddUserLinkUserVO;
import cn.ekgc.itrip.pojo.vo.ItripModifyUserLinkUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/userinfo")
/***
 * <B>查询联系人</B>
 * @param vo
 * @return
 * @throws Exception
 */
public interface UserInfoTransport {
	@RequestMapping(value = "/getLinkUserListByLogin",method = RequestMethod.POST)
	List<UserLinkUser> getLinkUserListByLogin(@RequestParam String userCode)throws Exception;

	/***
	 * <b>删除联系人</b>
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deluserlinkuser",method = RequestMethod.POST)
	boolean deluserlinkuser(@RequestParam Long ids)throws Exception;


	/**
	 * <b>新增联系人</b>
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/adduserlinkuser",method = RequestMethod.POST)
	boolean adduserlinkuser(@RequestBody ItripAddUserLinkUserVO vo, @RequestParam Long userId) throws Exception;
	/**
	 * <b>修改联系人</b>
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/modifyuserlinkuser",method = RequestMethod.POST)
	boolean modifyuserlinkuser(@RequestBody ItripModifyUserLinkUserVO vo,@RequestParam Long userId)throws Exception;
}
