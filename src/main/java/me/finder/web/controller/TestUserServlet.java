package me.finder.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import me.finder.model.TestUser;
import me.finder.service.ITestUserService;

/**
 * 
 * @author finder
 * @WebServlet是Servlet3.0提供的注解，
 * 目的是将一个继承了HttpServlet类的普通java类标注为一个Servlet TestUserServlet
 * 使用了@WebServlet标注之后，就不需要在web.xml中配置了
 *
 */
//@WebServlet("/testUserServlet")
public class TestUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 处理业务逻辑的testUserService
	private ITestUserService testUserService;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有的用户信息
		List<TestUser> lstUsers = testUserService.getAllUser();
		request.setAttribute("lstUsers", lstUsers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// 在Servlet初始化时获取Spring上下文对象(ApplicationContext)
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		// 从ApplicationContext中获取userService
		testUserService = (ITestUserService) ac.getBean("testUserService");
	}

}
