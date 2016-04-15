package me.finder.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.finder.model.TestUser;
import me.finder.service.ITestUserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class MyBatisTestBySpringTestFramework {
	// 注入userService
	@Autowired
	private ITestUserService testUserService;

	@Test
	public void testAddUser() {
		TestUser user = new TestUser();
		user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setUserName("zhd_finder");
		user.setUserBirthday(new Date());
		user.setUserSalary(10000D);
		testUserService.addUser(user);
	}

	@Test
	public void testGetUserById() {
		String userId = "2e31f3ccfbf14369917f373ffe51a98d";
		TestUser user = testUserService.getUserById(userId);
		System.out.println(user.getUserName());
	}
}
