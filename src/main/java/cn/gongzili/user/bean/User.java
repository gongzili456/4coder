package cn.gongzili.user.bean;

public class User {

	public static final int USER_STATUS_NORMAL = 1;

	public static final String SESSION_USER = "user";

	private Long userId;
	private String userName;
	private String userEmail;
	private Long userRegisteDate;
	private String userPortrait;
	private String userPassword;
	private Integer userStatus;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserRegisteDate() {
		return userRegisteDate;
	}

	public void setUserRegisteDate(Long userRegisteDate) {
		this.userRegisteDate = userRegisteDate;
	}

	public String getUserPortrait() {
		return userPortrait;
	}

	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userRegisteDate="
				+ userRegisteDate + ", userPortrait=" + userPortrait
				+ ", userPassword=" + userPassword + ", userStatus="
				+ userStatus + "]";
	}

}
