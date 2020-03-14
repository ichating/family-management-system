package com.family.oa.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.family.oa.entity.UserEntity;
import com.family.oa.service.impl.UserServiceImpl;
/**
 * 用户管理
 * @author Jole
 */
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	UserServiceImpl userService = new UserServiceImpl();
	
	public void doGet(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws UnsupportedEncodingException {
		httpServletRequest.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("txt/html");
		try {
			this.doPost(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void doPost(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws UnsupportedEncodingException {
		httpServletRequest.setCharacterEncoding("UTF-8");
		try {
			String servletPath = httpServletRequest.getServletPath();
			String str = servletPath.substring(1).substring(0, servletPath.length()-4);
			Method method = getClass().getDeclaredMethod(str, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, httpServletRequest,httpServletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**用户登录 */
	public void loginUser(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws Exception {
		String user_name = httpServletRequest.getParameter("user_name");
		String user_password = httpServletRequest.getParameter("user_password");		
		UserEntity user = userService.login(user_name, user_password);
		if(user.getUser_name()!=null) {
			httpServletRequest.getSession().setAttribute("userName", user.getName());
			httpServletRequest.setAttribute("info", "欢迎"+user_name+"登录");
			httpServletRequest.getRequestDispatcher("/manager.jsp").forward(httpServletRequest, httpServletResponse);
		}else {
			httpServletRequest.setAttribute("info", "登录失败，请重新登录！");
			httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
		}
	}
	
	/**查询所有用户 */
	public void users(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse){
		try {
		List<UserEntity> findAll = userService.findAll();
		httpServletRequest.setAttribute("findAll", findAll);
		httpServletRequest.getRequestDispatcher("/users.jsp").forward(httpServletRequest, httpServletResponse);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 添加用户*/
	protected void addUser(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException{
		String user_name = httpServletRequest.getParameter("user_loginName");
		String name = httpServletRequest.getParameter("user_name");
		String user_password = httpServletRequest.getParameter("user_password");
		Date birthday = Date.valueOf(httpServletRequest.getParameter("user_birthday"));
		String tel = httpServletRequest.getParameter("user_tel");
		String remarks = httpServletRequest.getParameter("remarks");
		Date date = new Date(new java.util.Date().getTime());
		UserEntity user = new UserEntity();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setBirthday(new Date(birthday.getTime()));
		user.setTel(tel);
		user.setName(name);
		user.setRemarks(remarks);
		user.setUpdate_time(date);
		userService.save(user);
		httpServletRequest.getSession().setAttribute("sucess", "添加成功！");
		System.out.println(httpServletRequest.getLocalAddr());
		httpServletResponse.sendRedirect("users.do");
	}
	
	/** 删除用户*/
	public void delUser(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException {
		String id = httpServletRequest.getParameter("userId");
		userService.delete(Integer.valueOf(id));
		httpServletRequest.setAttribute("ok", "删除成功");
		httpServletRequest.getRequestDispatcher("users.do").forward(httpServletRequest, httpServletResponse);
	}
	
	/** 修改用户*/
	public void updateUser(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException {
		String user_name = httpServletRequest.getParameter("user_loginName");
		String name = httpServletRequest.getParameter("user_name");
		String user_password = httpServletRequest.getParameter("user_password");
		Date birthday = Date.valueOf(httpServletRequest.getParameter("user_birthday"));
		String tel = httpServletRequest.getParameter("user_tel");
		String remarks = httpServletRequest.getParameter("remarks");
		String id = httpServletRequest.getParameter("userId");
		Date date = new Date(new java.util.Date().getTime());
		UserEntity user = userService.getOne(Integer.valueOf(id));
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setBirthday(new Date(birthday.getTime()));
		user.setTel(tel);
		user.setName(name);
		user.setRemarks(remarks);
		user.setUpdate_time(date);
		userService.update(user);
		httpServletRequest.getRequestDispatcher("users.do").forward(httpServletRequest, httpServletResponse);
	}
	
	public void findOne(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException {
		String id = httpServletRequest.getParameter("userId");
		UserEntity user = userService.getOne(Integer.valueOf(id));
		httpServletRequest.setAttribute("findOne", user);
		httpServletRequest.getRequestDispatcher("/updateUsers.jsp").forward(httpServletRequest, httpServletResponse);
	}
	
	/**模糊查询 */
	public void findUserByNameOrTel(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse){
		try {
			String name = httpServletRequest.getParameter("name");
			String tel = httpServletRequest.getParameter("tel");
		List<UserEntity> findAll = userService.findUserByNameOrTel(name,tel);
		httpServletRequest.setAttribute("findAll", findAll);
		httpServletRequest.getRequestDispatcher("/users.jsp").forward(httpServletRequest, httpServletResponse);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
