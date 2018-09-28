package com.yagizhanbadir.model;

public class User {

	private String userName;
	private String password;
    private String userUuid;

	public User(String userName, String password, String userUuid) {

		this.userName = userName;
		this.password = password;
		this.userUuid = userUuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return userUuid;
	}

	public void setUuid(String uuid) {
		this.userUuid = uuid;
	}

}
