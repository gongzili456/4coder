package cn.gongzili.user.dao;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.gongzili.user.bean.User;
import cn.gongzili.user.controller.UserController;

@Component
public class UserDaoImpl implements UserDao {
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	JdbcTemplate jt;

	@Override
	public boolean inserUser(User u) {
		String sql = "INSERT INTO users(user_name, user_email, user_registe_date, user_portrait, user_password, user_status) VALUES(?, ?, ?, ?, ?, ?)";
		Object[] args = new Object[] { u.getUserName(), u.getUserEmail(),
				u.getUserRegisteDate(), u.getUserPortrait(),
				u.getUserPassword(), u.getUserStatus() };
		int colw = jt.update(sql, args);
		return colw > 0 ? true : false;
	}

	@Override
	public User findUserByEmail(String email) {
		String sql = "SELECT * FROM users WHERE user_email = ?";
		List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(
				User.class), email);

		logger.info("SELECT * FROM users WHERE user_email = " + email + ";"
				+ list);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Collection<String> findRolesByEmail(String email) {
		String sql = "SELECT r.name FROM users u, roles r, user_role ur WHERE u.user_email = ? AND u.user_id = ur.user_id AND ur.role_id = r.id";
		return jt.queryForList(sql, String.class, email);
	}

	@Override
	public boolean insertUserRole(long userId, long roleId) {
		String sql = "INSERT INTO user_role(user_id, role_id) VALUES (?, ?)";
		int rs = jt.update(sql, userId, roleId);
		return rs > 0 ? true : false;
	}

	@Override
	public User findUserByUserId(long userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(
				User.class), userId);

		logger.info("SELECT * FROM users WHERE user_id = " + userId + ";"
				+ list);
		return list.isEmpty() ? null : list.get(0);
	}

}
