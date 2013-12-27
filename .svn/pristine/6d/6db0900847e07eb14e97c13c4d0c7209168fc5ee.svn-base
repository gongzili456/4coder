package cn.gongzili.user.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.gongzili.topic.service.TopicService;
import cn.gongzili.user.bean.User;
import cn.gongzili.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	TopicService topicService;

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Map<String, Object>> topics = topicService.queryTopicList();
		model.addAttribute("topics", JSONArray.fromObject(topics));
		return "home";
	}

	@RequestMapping("/role/view")
	public ModelAndView role() {
		return new ModelAndView("role");
	}

	@RequestMapping("/403")
	public ModelAndView decline() {
		return new ModelAndView("403");
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/loginProccess")
	public ModelAndView doLogin(HttpServletRequest request, Model model) {
		Subject subject = SecurityUtils.getSubject();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(email, pass);
		try {
			subject.login(token);
		} catch (UnknownAccountException ua) {
			ua.printStackTrace();
			model.addAttribute("rs", 0);
			model.addAttribute("message", "用户不存在");
			logger.info("UnknownAccount " + email);
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			model.addAttribute("rs", 0);
			model.addAttribute("message", "用户名或密码错误");
			logger.info("PassWord didn't match for Account:" + email);
		} catch (LockedAccountException e) {
			e.printStackTrace();
			model.addAttribute("rs", 0);
			model.addAttribute("message", "该用户被锁定");
			logger.info("This Account is Locked!" + email);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			model.addAttribute("rs", 0);
			model.addAttribute("message", "未知错误");
			logger.info("login Exception" + email);
		}
		return new ModelAndView("redirect:/");

	}

	@RequestMapping("/register")
	public ModelAndView registe() {
		return new ModelAndView("register");
	}

	@RequestMapping("/registerProccess")
	public RedirectView doRegiste(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		User u = new User();
		u.setUserEmail(email);
		u.setUserName(name);
		u.setUserPassword(pass);
		u.setUserRegisteDate(System.currentTimeMillis());
		u.setUserStatus(User.USER_STATUS_NORMAL);
		if (userService.inserUser(u)) {
			UsernamePasswordToken token = new UsernamePasswordToken(email, pass);
			SecurityUtils.getSubject().login(token);
		}
		return new RedirectView("/");
	}

	@RequestMapping("/loginout")
	public ModelAndView loginOut() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.getSession() != null) {
			currentUser.logout();
		}
		return new ModelAndView("redirect:/login");
	}

}
