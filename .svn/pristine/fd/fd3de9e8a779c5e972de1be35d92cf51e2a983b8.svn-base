package cn.gongzili.topic.dao;

import java.util.List;

import cn.gongzili.topic.bean.Topic;

public interface TopicDao {

	boolean insertTopic(Topic t);

	List<Topic> queryTopicList();

	Topic queryTopicById(long topicId);

	boolean topicOption(long userId, long topicId, int type);

	boolean topicOptionRemove(long userId, long topicId, int type);

	boolean updateTopic(Topic t);

	boolean queryTopicOption(long topicId, long userId);
}
