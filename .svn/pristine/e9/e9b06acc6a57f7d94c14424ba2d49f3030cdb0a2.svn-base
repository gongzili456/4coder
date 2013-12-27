package cn.gongzili.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.gongzili.topic.bean.Topic;
import cn.gongzili.topic.dao.TopicDao;

public class TopicDaoTest {

	@Test
	public void testInsertTopic() {
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"D:\\Workspaces\\eclipse\\wk2\\spring_shiro\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
		TopicDao topicDao = ac.getBean(TopicDao.class);
		Topic t = new Topic();

		t.setTopicUserId(6l);
		t.setTopicContent("测试帖子");
		t.setTopicDate(System.currentTimeMillis());
		t.setTopicTitle("测试帖子标题");
		t.setTopicStatus(1);
		t.setTopicType(1);

		topicDao.insertTopic(t);
	}
}
