package me.finder.service;

import com.sun.tools.javac.util.List;

import me.finder.model.TestUser;

public interface ITestUserService {
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	void addUser(TestUser user);

	/**
	 * 根据用户id获取用户
	 * 
	 * @param userId
	 * @return
	 */
	TestUser getUserById(String userId);
	
	/**
	 * 获取所有用户信息
	 * @return	List<TestUser>
	 */
	List<TestUser> getAllUser();
}
