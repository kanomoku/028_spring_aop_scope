package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pojo.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private Users user1;
	private Users user2;

	@Override
	public void init() throws ServletException {
		WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		user1 = ac.getBean("user", Users.class);
		user2 = ac.getBean("user", Users.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("user1"+user1);
		System.out.println("user2"+user2);//servlet是单例的，这里也受到servlet的影响
		WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Users user3= ac.getBean("user", Users.class);
		Users user4= ac.getBean("user", Users.class);
		System.out.println("user3"+user3);
		System.out.println("user4"+user4);
	}
}
