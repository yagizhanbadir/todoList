package com.yagizhanbadir.services;


import java.util.UUID;
public class UserService  {

	
//	private static List<User> login = new ArrayList<User>();
	private UserDao userDao = new UserDaoDatabaseImpl();

	// ok
	public void addUser(String name, String password) {
		String id = UUID.randomUUID().toString();
		// User newUser = new User(name, password, id);
		// login.add(newUser);
		userDao.addUser(name, password, id);

	}

	// ok.
	public boolean isUserValid(String username, String password) {
//
//		for (User l : login) {
//			if (l.getUserName().equals(username) && l.getPassword().equals(password))
//				return true;
//		}
//		return false;

		boolean is = userDao.user(username, password);
		if (is) {
			return is;
		}
		return false;
	}

	// ok.
	public String getUserId(String username) {
//
//		for (User l : login) {
//			if (l.getUserName().equals(username))
//				return l.getUuid();
//		}
//		return null;

		return userDao.getUserId(username);

	}

}
