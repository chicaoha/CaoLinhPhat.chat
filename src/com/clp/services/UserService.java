package com.clp.services;

import com.clp.data.DataStorage;
import com.clp.entity.Group;
import com.clp.entity.User;
public class UserService {
	private final DataStorage storage;

	public UserService(DataStorage storage) {
		super();
		this.storage = storage;
	}
	
	public boolean login(String username, String password) {
		User attemptedUser = storage.getUsers().getFirst(user-> user.getUserName().equals(username));
		if(attemptedUser == null) {
			return false;
		}
		return attemptedUser.login(password);
	}
	
	public boolean addUser (String username, String password) {
		User existing = storage.getUsers().getFirst(user -> user.getUserName().equals(username));
		if(existing != null) {
			return false;
		}
		
		User newUser = new User(username,password);
		storage.getUsers().insert(newUser);
		return true;
	}
	public Group createGroup(String groupType, int groupID, String groupName) {
		Group group= new Group() {
		};
		generateCode();
		return null;
		
	}
}
