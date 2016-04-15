package me.finder.dao;

import com.sun.tools.javac.util.List;

import me.finder.model.TestUser;

public interface TestUserMapper {
	int deleteByPrimaryKey(String userId);

	int insert(TestUser record);

	int insertSelective(TestUser record);

	TestUser selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(TestUser record);

	int updateByPrimaryKey(TestUser record);
	
	/**
	 * 获取所有用户
	 * @return	List<TestUser>
	 */
	List<TestUser> getAllUser();
}