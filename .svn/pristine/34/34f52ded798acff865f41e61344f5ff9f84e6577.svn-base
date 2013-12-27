package cn.gongzili.topic.bean;

public class TopicOption implements java.io.Serializable {
	// 1赞，2踩，3收藏，4分享
	public static final int OPTION_FAVOUR = 1;
	public static final int OPTION_HATE = 2;
	public static final int OPTION_COLLECT = 3;
	public static final int OPTION_SHARE = 4;

	private static final long serialVersionUID = -7367159183847313769L;
	private Long id;
	private Long topicId;
	private Long userId;
	private Integer type;
	private Long date;

	public TopicOption() {
	}

	public TopicOption(Long topicId, Long userId, Integer type, Long date) {
		this.topicId = topicId;
		this.userId = userId;
		this.type = type;
		this.date = date;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getDate() {
		return this.date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TopicOption [id=" + id + ", topicId=" + topicId + ", userId="
				+ userId + ", type=" + type + ", date=" + date + "]";
	}

}