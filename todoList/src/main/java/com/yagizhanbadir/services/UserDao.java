package com.yagizhanbadir.services;

public interface UserDao {
	
	public String getUserId(String username);
	public void addUser(String userName, String password, String userId);
	public boolean user(String username, String password);

}
