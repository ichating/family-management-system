package com.family.oa.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.family.oa.service.impl.TypesServiceImpl;

public class TypesController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	TypesServiceImpl type = new TypesServiceImpl();
	
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
			HttpSession session = httpServletRequest.getSession();
			Object attribute = session.getAttribute("userName");
			if(attribute==null) {
				httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
			}
			String servletPath = httpServletRequest.getServletPath();
			String str = servletPath.substring(1).substring(0, servletPath.length()-4);
			Method method = getClass().getDeclaredMethod(str, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, httpServletRequest,httpServletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
