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
import javax.servlet.http.HttpSession;

import com.family.oa.entity.PageBean;
import com.family.oa.entity.RepaymentEntity;
import com.family.oa.entity.TypesEntity;
import com.family.oa.entity.UserEntity;
import com.family.oa.service.RepaymentService;
import com.family.oa.service.UserService;
import com.family.oa.service.impl.RepaymentServiceImpl;
import com.family.oa.service.impl.TypesServiceImpl;
import com.family.oa.service.impl.UserServiceImpl;
/**
 * 支出管理
 * @author Jole
 *
 */
public class RepaymentController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	RepaymentService repaymentService = new RepaymentServiceImpl();
	TypesServiceImpl type = new TypesServiceImpl();
	UserServiceImpl user = new UserServiceImpl();
	
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
			String str = servletPath.substring(1).substring(0, servletPath.length()-5);
			Method method = getClass().getDeclaredMethod(str, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, httpServletRequest,httpServletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有支出记录
	 */
	public void repayments(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException{
		HttpSession session = httpServletRequest.getSession();
		Object attribute = session.getAttribute("userName");
		if(attribute==null) {
			try {
				httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RepaymentEntity repayment = new RepaymentEntity();
		String name = httpServletRequest.getParameter("name");
		String repayment_user = httpServletRequest.getParameter("repayment_user");
		String remarks = httpServletRequest.getParameter("remarks");
		repayment.setName(name);
		repayment.setRepayment_user(repayment_user);
		repayment.setRemarks(remarks);
		//获取数据
        String currentPage = httpServletRequest.getParameter("currentPage");
        String rows = httpServletRequest.getParameter("rows");
        if(null==currentPage||"".equals(currentPage)){
            currentPage="1";
        }
        if(null==rows||"".equals(rows)){
            rows="8";
        }
        PageBean <RepaymentEntity> pageBean = repaymentService.findAll(Integer.parseInt(currentPage), Integer.parseInt(rows),repayment);
		httpServletRequest.setAttribute("pageBean", pageBean);
		httpServletRequest.getRequestDispatcher("/repayment.jsp").forward(httpServletRequest, httpServletResponse);
	}
	
	/**
	 * 带出类型列表数据
	 */
	public void dispatcherType(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException{
		List<TypesEntity> findAllTypes = type.findAll();
		List<UserEntity> findAllUsers = user.findAll();
		httpServletRequest.setAttribute("findAllTypes", findAllTypes);
		httpServletRequest.setAttribute("findAllUsers", findAllUsers);
		httpServletRequest.getRequestDispatcher("/addRepayment.jsp").forward(httpServletRequest, httpServletResponse);
	}
	
	/**
	 * 添加支出记录
	 */
	public void addRepayment(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException{
		String name = httpServletRequest.getParameter("name");
		String repayment_user = httpServletRequest.getParameter("repayment_user");
		String repayment_amount = httpServletRequest.getParameter("repayment_amount");
		String remarks = httpServletRequest.getParameter("remarks");
		Date update_time = (Date.valueOf(httpServletRequest.getParameter("update_time")));
		HttpSession session = httpServletRequest.getSession();
		Object attribute = session.getAttribute("userName");
		String user_name = attribute.toString();
		repaymentService.insert(name, repayment_amount,new Date(update_time.getTime()) ,repayment_user,user_name,remarks);
//		if(n) {
//			httpServletRequest.getSession().setAttribute("sucess", "添加成功！");
//			System.out.println(httpServletRequest.getLocalAddr());
//			httpServletResponse.sendRedirect("repayments.out");
//		}else {
//			httpServletRequest.getSession().setAttribute("sucess", "添加失败！");
//			httpServletResponse.sendRedirect("repayments.out");
//		}
		httpServletResponse.sendRedirect("repayments.out");
	}
	
	/**
	 * 删除支出记录
	 */
	public void delRepayment(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException {
		String repaymentId = httpServletRequest.getParameter("repaymentId");
		repaymentService.deleteRepayment(repaymentId);
		httpServletRequest.getRequestDispatcher("repayments.out").forward(httpServletRequest, httpServletResponse);
//		if(n>=0) {
//			httpServletRequest.setAttribute("ok", "删除成功");
//			httpServletRequest.getRequestDispatcher("repayments.out").forward(httpServletRequest, httpServletResponse);
//		}else {
//			httpServletRequest.setAttribute("ok", "删除失败");
//			httpServletResponse.sendRedirect("repayments.out");
//		}
	}
	
	/**分页查询所有用户 */
	public void findRepaymentByPageServlet(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse){
		HttpSession session = httpServletRequest.getSession();
		Object attribute = session.getAttribute("userName");
		if(attribute==null) {
			try {
				httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//获取数据
        String currentPage = httpServletRequest.getParameter("currentPage");
        String rows = httpServletRequest.getParameter("rows");
        if(null==currentPage||"".equals(currentPage)){
            currentPage="1";
        }
        if(null==rows||"".equals(rows)){
            rows="8";
        }
        //调用service
        PageBean<RepaymentEntity> pageBean = repaymentService.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows));
        httpServletRequest.setAttribute("pageBean", pageBean);
        //转发
        try {
			httpServletRequest.getRequestDispatcher("/repayment.jsp").forward(httpServletRequest, httpServletResponse);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
