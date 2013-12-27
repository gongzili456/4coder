package cn.gongzili.user.dao;

import java.util.Collection;

import cn.gongzili.user.bean.User;

public interface UserDao {
	boolean inserUser(User u);

	User findUserByEmail(String email);

	User findUserByUserId(long userId);

	Collection<String> findRolesByEmail(String email);

	boolean insertUserRole(long userId, long roleId);
}
