package me.finder.test;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.finder.model.TestUser;
import me.finder.service.ITestUserService;

public class MyBatisTest {

	private ITestUserService testUserService;

	/**
	 * 这个before方法在所有的测试方法之前执行，并且只执行一次 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
	 * 比如在before方法里面初始化ApplicationContext和userService
	 */
	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" });
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		testUserService = (ITestUserService) ac.getBean("testUserService");
	}

	@Test
	public void testAddUser() {
		// ApplicationContext ac = new ClassPathXmlApplicationContext(new
		// String[]{"spring.xml","spring-mybatis.xml"});
		// ITestUserService userService = (ITestUserService)
		// ac.getBean("testUserService");
		TestUser user = new TestUser();
		user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setUserName(UUID.randomUUID().toString().substring(0, 6)+"_finder");
		user.setUserBirthday(new Date());
		user.setUserSalary(new Random().nextDouble());
		testUserService.addUser(user);
	}
	
	@Test
	public void testGetAllUser(){
		List<TestUser> list = testUserService.getAllUser();
		for( TestUser tu : list ){
			System.out.println(tu.toString());
		}
	}

}
