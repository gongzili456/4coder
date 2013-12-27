package cn.gongzili.topic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.gongzili.topic.bean.Topic;

@Component
public class TopicDaoImpl implements TopicDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	public boolean insertTopic(Topic t) {
		String sql = "INSERT topics(topic_user_id, topic_date, topic_content, topic_title, topic_excerpt, topic_status, comment_count,"
				+ " favour_count, collect_count, share_count, hate_count, topic_type, topic_location, topic_longitude, topic_latitude, topic_modified, topic_client) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = new Object[] { t.getTopicUserId(), t.getTopicDate(),
				t.getTopicContent(), t.getTopicTitle(), t.getTopicExcerpt(),
				t.getTopicStatus(), t.getCommentCount(), t.getFavourCount(),
				t.getCollectCount(), t.getShareCount(), t.getHateCount(),
				t.getTopicType(), t.getTopicLocation(), t.getTopicLongitude(),
				t.getTopicLatitude(), t.getTopicModified(), t.getTopicClient() };
		int rs = jt.update(sql, args);
		return rs > 0 ? true : false;
	}

	@Override
	public List<Topic> queryTopicList() {
		String sql = "SELECT * FROM topics";
		return jt.query(sql, new BeanPropertyRowMapper<Topic>(Topic.class));
	}

	@Override
	public boolean topicOption(long userId, long topicId, int type) {
		String sql = "INSERT INTO topic_option(topic_id, user_id, TYPE, DATE) VALUES(?, ?, ?, ?)";
		int rs = jt.update(sql, topicId, userId, type,
				System.currentTimeMillis());
		return rs > 0 ? true : false;
	}

	@Override
	public boolean topicOptionRemove(long userId, long topicId, int type) {
		String sql = "DELETE FROM topic_option WHERE topic_id = ? AND user_id = ? AND TYPE = ?";
		int rs = jt.update(sql, topicId, userId, type);
		return rs > 0 ? true : false;
	}

	@Override
	public boolean updateTopic(Topic t) {
		String sql = "UPDATE topics SET topic_user_id = ?, topic_date = ?, topic_content = ?, topic_title = ?, topic_excerpt = ?, topic_status = ?, comment_count = ?,"
				+ " favour_count = ?, collect_count = ?, share_count = ?, hate_count = ?, topic_type = ?, topic_location = ?, topic_longitude = ?, topic_latitude = ?, topic_modified = ?, topic_client = ? WHERE topic_id = ?";
		Object[] args = new Object[] { t.getTopicUserId(), t.getTopicDate(),
				t.getTopicContent(), t.getTopicTitle(), t.getTopicExcerpt(),
				t.getTopicStatus(), t.getCommentCount(), t.getFavourCount(),
				t.getCollectCount(), t.getShareCount(), t.getHateCount(),
				t.getTopicType(), t.getTopicLocation(), t.getTopicLongitude(),
				t.getTopicLatitude(), t.getTopicModified(), t.getTopicClient(),
				t.getTopicId() };
		int rs = jt.update(sql, args);
		return rs > 0 ? true : false;
	}

	@Override
	public Topic queryTopicById(long topicId) {
		String sql = "SELECT * FROM topics WHERE topic_id = ?";
		List<Topic> list = jt.query(sql, new BeanPropertyRowMapper<Topic>(
				Topic.class), topicId);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean queryTopicOption(long topicId, long userId) {
		String sql = "SELECT id FROM topic_option WHERE topic_id = ? AND user_id = ?";
		List<Integer> list = jt.queryForList(sql, Integer.class, topicId,
				userId);
		return list.isEmpty() ? false : true;
	}
}
