package com.great.cms.dao;



import java.util.List;

import com.great.cms.entity.User;


public interface UserDao extends GenericDao<User, Long>{
	
	public void deleteAll();
	public boolean usernameExists(String username);
	public User findByUsername(String username);
	public Integer countUsers();
	public Integer countVerificationNeed();
}
