package cn.gongzili.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.gongzili.user.bean.User;
import cn.gongzili.user.dao.UserDao;

public class DaoTest {

	@Test
	public void testDao() {
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"D:\\Workspaces\\eclipse\\wk2\\spring_shiro\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
		UserDao dao = ac.getBean(UserDao.class);
		User u = dao.findUserByEmail("aaa@sina.com");
		System.out.println(u);
	}
}
