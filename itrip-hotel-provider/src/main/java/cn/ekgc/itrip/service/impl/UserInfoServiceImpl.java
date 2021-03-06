package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserInfoDao;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.entity.OrderLinkUser;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.ItripAddUserLinkUserVO;
import cn.ekgc.itrip.pojo.vo.ItripModifyUserLinkUserVO;
import cn.ekgc.itrip.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.*;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	/***
	 * <B>查询联系人</B>
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<UserLinkUser> getLinkUserListByLogin(String userCode) throws Exception {
		Map<String,Object>queryMap=new HashMap<String, Object>();
		queryMap.put("userCode", userCode);
		List<UserLinkUser>userLinkUserList=userInfoDao.findLinkUserListByQuery(queryMap);
		return userLinkUserList;
	}




	/***
	 * <b>删除联系人</b>
	 * @param ids
	 * @return
	 */
	public boolean deluserlinkuser( Long[] ids) throws Exception {
		List<OrderLinkUser>userList=userInfoDao.findUserListByQuery();
		List<Long>list=new ArrayList();
		for (OrderLinkUser orderLinkUser:userList) {
			list.add(orderLinkUser.getLinkUserId());
		}
		for (Long id : ids) {
			if (!list.contains(id)) {
				boolean flag=userInfoDao.deluserlinkuser(id);
			}
		}

		return true;
	}


	/**
	 * <B>新增联系人</B>
	 * @param vo
	 * @param userId
	 * @return
	 */
	public boolean adduserlinkuser(ItripAddUserLinkUserVO vo, Long userId) throws Exception {
		UserLinkUser userLinkUser=new UserLinkUser();
		BeanUtils.copyProperties(vo, userLinkUser);
		userLinkUser.setUserId(userId);
		try {
			userInfoDao.adduserlinkuser(userLinkUser);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * <b>修改联系人</b>
	 * @param vo
	 * @return
	 */
	public boolean modifyuserlinkuser(ItripModifyUserLinkUserVO vo, Long userId) throws Exception {
		UserLinkUser userLinkUser=new UserLinkUser();
		BeanUtils.copyProperties(vo, userLinkUser);
		userLinkUser.setUserId(userId);
		userLinkUser.setModifyDate(new Date());
		userLinkUser.setModifiedBy(userId);
		boolean flag=userInfoDao.modifyuserlinkuser(userLinkUser);
				if (flag){
					return true;
				}
		return false;
	}


}
