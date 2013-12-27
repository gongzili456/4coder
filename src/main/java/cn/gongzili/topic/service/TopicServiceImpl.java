package cn.gongzili.topic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.gongzili.topic.bean.Topic;
import cn.gongzili.topic.bean.TopicOption;
import cn.gongzili.topic.dao.TopicDao;
import cn.gongzili.user.bean.User;
import cn.gongzili.user.dao.UserDao;

@Component
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicDao topicDao;

	@Autowired
	UserDao userDao;

	@Override
	public boolean insertTopic(Topic t) {
		return topicDao.insertTopic(t);
	}

	@Override
	public List<Map<String, Object>> queryTopicList() {
		List<Topic> topics = topicDao.queryTopicList();

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (Topic t : topics) {
			User u = userDao.findUserByUserId(t.getTopicUserId());
			map = new HashMap<String, Object>();
			map.put("user", u);
			map.put("topic", t);
			list.add(map);
		}
		return list;
	}

	@Override
	public boolean topicOption(long userId, long topicId, int type) {

		Topic topic = topicDao.queryTopicById(topicId);

		handleOptionType(type, topic, false);
		boolean rs = topicDao.updateTopic(topic);
		if (rs) {
			if (topicDao.topicOption(userId, topicId, type)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean topicOptionRemove(long userId, long topicId, int type) {
		Topic topic = topicDao.queryTopicById(topicId);
		handleOptionType(type, topic, true);
		boolean rs = topicDao.updateTopic(topic);
		if (rs) {
			if (topicDao.topicOptionRemove(userId, topicId, type)) {
				return true;
			}
		}
		return false;
	}

	private void handleOptionType(int type, Topic t, boolean isRemove) {
		switch (type) {
		case TopicOption.OPTION_COLLECT:
			if (isRemove) {
				t.setCollectCount(t.getCollectCount() - 1);
			} else {
				t.setCollectCount(t.getCollectCount() + 1);
			}
			break;
		case TopicOption.OPTION_FAVOUR:
			if (isRemove) {
				t.setFavourCount(t.getFavourCount() - 1);
			} else {
				t.setFavourCount(t.getFavourCount() + 1);
			}
			break;
		case TopicOption.OPTION_HATE:
			if (isRemove) {
				t.setHateCount(t.getHateCount() - 1);
			} else {
				t.setHateCount(t.getHateCount() + 1);
			}
			break;
		case TopicOption.OPTION_SHARE:
			if (isRemove) {
				t.setShareCount(t.getShareCount() - 1);
			} else {
				t.setShareCount(t.getShareCount() + 1);
			}
			break;
		}
	}

	@Override
	public boolean queryTopicOption(long topicId, long userId) {
		return topicDao.queryTopicOption(topicId, userId);
	}
}
