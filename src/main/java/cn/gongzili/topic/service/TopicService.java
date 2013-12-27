package cn.gongzili.topic.service;

import java.util.List;
import java.util.Map;

import cn.gongzili.topic.bean.Topic;

public interface TopicService {
	boolean insertTopic(Topic t);

	List<Map<String, Object>> queryTopicList();

	boolean topicOption(long userId, long topicId, int type);

	boolean topicOptionRemove(long userId, long topicId, int type);

	boolean queryTopicOption(long topicId, long userId);
}
