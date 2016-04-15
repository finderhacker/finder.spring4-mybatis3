package me.finder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.javac.util.List;

import me.finder.dao.TestUserMapper;
import me.finder.model.TestUser;
import me.finder.service.ITestUserService;

/**
 * @author finder 使用@Service注解将UserServiceImpl类标注为一个service service的id是userService
 */
@Service
public class TestUserService implements ITestUserService {

	/**
	 * 使用@Autowired注解标注userMapper变量， 当需要使用UserMapper时，Spring就会自动注入UserMapper
	 */
	@Autowired
	private TestUserMapper testUserMapper;	//注入dao

	public void addUser(TestUser user) {
		testUserMapper.insert(user);
	}

	public TestUser getUserById(String userId) {
		return testUserMapper.selectByPrimaryKey(userId);
	}

	public List<TestUser> getAllUser() {
		return testUserMapper.getAllUser();
	}

}
