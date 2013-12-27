package cn.gongzili.topic.bean;

public class Topic implements java.io.Serializable {
	private static final long serialVersionUID = 5431836485436721372L;

	public static final int TOPIC_STATUS_NORMAL = 1;

	private Long topicId;
	private Long topicUserId;
	private Long topicDate;
	private String topicContent;
	private String topicTitle;
	private String topicExcerpt;
	private Integer topicStatus;
	private Long commentCount = 0l;
	private Long favourCount = 0l;
	private Long collectCount = 0l;
	private Long shareCount = 0l;
	private Long hateCount = 0l;
	private Integer topicType;
	private String topicLocation;
	private Double topicLongitude;
	private Double topicLatitude;
	private Long topicModified;
	private String topicClient;

	public Topic() {
	}

	public Topic(Long topicUserId) {
		this.topicUserId = topicUserId;
	}

	public Topic(Long topicUserId, Long topicDate, String topicContent,
			String topicTitle, String topicExcerpt, Integer topicStatus,
			Long commentCount, Long favourCount, Long collectCount,
			Long shareCount, Long hateCount, Integer topicType,
			String topicLocation, Double topicLongitude, Double topicLatitude,
			Long topicModified, String topicClient) {
		this.topicUserId = topicUserId;
		this.topicDate = topicDate;
		this.topicContent = topicContent;
		this.topicTitle = topicTitle;
		this.topicExcerpt = topicExcerpt;
		this.topicStatus = topicStatus;
		this.commentCount = commentCount;
		this.favourCount = favourCount;
		this.collectCount = collectCount;
		this.shareCount = shareCount;
		this.hateCount = hateCount;
		this.topicType = topicType;
		this.topicLocation = topicLocation;
		this.topicLongitude = topicLongitude;
		this.topicLatitude = topicLatitude;
		this.topicModified = topicModified;
		this.topicClient = topicClient;
	}

	public Long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getTopicUserId() {
		return this.topicUserId;
	}

	public void setTopicUserId(Long topicUserId) {
		this.topicUserId = topicUserId;
	}

	public Long getTopicDate() {
		return this.topicDate;
	}

	public void setTopicDate(Long topicDate) {
		this.topicDate = topicDate;
	}

	public String getTopicContent() {
		return this.topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public String getTopicTitle() {
		return this.topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicExcerpt() {
		return this.topicExcerpt;
	}

	public void setTopicExcerpt(String topicExcerpt) {
		this.topicExcerpt = topicExcerpt;
	}

	public Integer getTopicStatus() {
		return this.topicStatus;
	}

	public void setTopicStatus(Integer topicStatus) {
		this.topicStatus = topicStatus;
	}

	public Long getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getFavourCount() {
		return this.favourCount;
	}

	public void setFavourCount(Long favourCount) {
		this.favourCount = favourCount;
	}

	public Long getCollectCount() {
		return this.collectCount;
	}

	public void setCollectCount(Long collectCount) {
		this.collectCount = collectCount;
	}

	public Long getShareCount() {
		return this.shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public Long getHateCount() {
		return this.hateCount;
	}

	public void setHateCount(Long hateCount) {
		this.hateCount = hateCount;
	}

	public Integer getTopicType() {
		return this.topicType;
	}

	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}

	public String getTopicLocation() {
		return this.topicLocation;
	}

	public void setTopicLocation(String topicLocation) {
		this.topicLocation = topicLocation;
	}

	public Double getTopicLongitude() {
		return this.topicLongitude;
	}

	public void setTopicLongitude(Double topicLongitude) {
		this.topicLongitude = topicLongitude;
	}

	public Double getTopicLatitude() {
		return this.topicLatitude;
	}

	public void setTopicLatitude(Double topicLatitude) {
		this.topicLatitude = topicLatitude;
	}

	public Long getTopicModified() {
		return this.topicModified;
	}

	public void setTopicModified(Long topicModified) {
		this.topicModified = topicModified;
	}

	public String getTopicClient() {
		return this.topicClient;
	}

	public void setTopicClient(String topicClient) {
		this.topicClient = topicClient;
	}

}