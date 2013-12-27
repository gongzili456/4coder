package cn.gongzili.shiro;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.gongzili.user.bean.User;
import cn.gongzili.user.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		Collection<String> roles = userService.findRolesByEmail(principals
				.iterator().next().toString());

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);

		System.out.println("roles:" + roles);
		System.out.println("principals:" + principals);

		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		System.out.println(token + "~~~~~~~~~~~~~~~~~");
		User user = null;
		try {
			String name = token.getUsername();
			user = userService.findUserByEmail(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user + "~~~~~~~~~~~~~~~~~");
		if (user != null) {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute(User.SESSION_USER, user);
			return new SimpleAuthenticationInfo(user.getUserEmail(),
					user.getUserPassword(), user.getUserName());
		}
		return null;
	}
}
