package cn.gongzili.user.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.gongzili.user.bean.User;
import cn.gongzili.user.dao.UserDao;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public boolean inserUser(User u) {
		if (userDao.findUserByEmail(u.getUserEmail()) == null) {
			boolean rs = this.userDao.inserUser(u);
			if (rs) {
				userDao.insertUserRole(findUserByEmail(u.getUserEmail())
						.getUserId(), 1);
			}
			return rs;
		}
		return false;
	}

	@Override
	public User findUserByEmail(String email) {
		return this.userDao.findUserByEmail(email);
	}

	@Override
	public Collection<String> findRolesByEmail(String email) {
		return userDao.findRolesByEmail(email);
	}

}
