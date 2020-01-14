package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.ItripAddUserLinkUserVO;
import cn.ekgc.itrip.pojo.vo.ItripModifyUserLinkUserVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserInfoService {
	/***
	 * <B>查询联系人</B>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> getLinkUserListByLogin(String userCode)throws Exception;

	/***
	 * <b>删除联系人</b>
	 * @param ids
	 * @return
	 */
	boolean deluserlinkuser( Long ids)throws Exception;


	/**
	 * <B>新增联系人</B>
	 * @param vo
	 * @param userId
	 * @return
	 */
	boolean adduserlinkuser(ItripAddUserLinkUserVO vo, Long userId)throws Exception;
	/**
	 * <b>修改联系人</b>
	 * @param vo
	 * @return
	 */
	boolean modifyuserlinkuser(ItripModifyUserLinkUserVO vo, Long userId)throws Exception;
}
