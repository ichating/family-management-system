package com.family.oa.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.family.oa.entity.LoanEntity;
import com.family.oa.entity.UserEntity;
import com.family.oa.service.impl.LoanServiceImpl;
import com.family.oa.service.impl.UserServiceImpl;

public class LoanController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LoanServiceImpl loanService = new LoanServiceImpl();
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
	
	/**查询所有用户 */
	public void loans(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException{
		String servletPath = httpServletRequest.getServletPath();
		LoanEntity loan =new LoanEntity();
		String user = httpServletRequest.getParameter("user");
		String types = httpServletRequest.getParameter("types");
		String remark = httpServletRequest.getParameter("remark");
		loan.setUser(user);
		loan.setTypes(types);
		loan.setRemark(remark);
		List<LoanEntity> findLoanList = loanService.findAll(loan);
		httpServletRequest.setAttribute("findLoanList", findLoanList);
		httpServletRequest.getRequestDispatcher("/loans.jsp").forward(httpServletRequest, httpServletResponse);
	}
	
	public void addLoan(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws IOException{
		String servletPath = httpServletRequest.getServletPath();
		String types = httpServletRequest.getParameter("types");
		String user = httpServletRequest.getParameter("user");
		String inMoney = httpServletRequest.getParameter("inMoney");
		String repaymentDay = httpServletRequest.getParameter("repaymentDay");
		String repaymentInDate = httpServletRequest.getParameter("repaymentInDate");
		String outMoney = httpServletRequest.getParameter("outMoney");
		String repaymentOutDate = httpServletRequest.getParameter("repaymentOutDate");
		String remark = httpServletRequest.getParameter("remark");
		Date date = new Date(new java.util.Date().getTime());
		HttpSession session = httpServletRequest.getSession();
		Object attribute = session.getAttribute("userName");
		String user_name = attribute.toString();
		
		LoanEntity loan = new LoanEntity();
		loan.setInMoney(BigDecimal.valueOf(Long.valueOf(inMoney)));
		loan.setOutMoney(BigDecimal.valueOf(Long.valueOf(outMoney)));
		loan.setRemark(remark);
		loan.setRepayment_time(date);
		loan.setRepaymentDay(Integer.valueOf(repaymentDay));
		loan.setRepaymentInDate(Date.valueOf(repaymentInDate));
		loan.setRepaymentOutDate(Date.valueOf(repaymentOutDate));
		loan.setTypes(types);
		loan.setUser(user);
		loan.setUser_name(user_name);
		loanService.save(loan);
		httpServletResponse.sendRedirect("loans.go");
	}
	
	public void delLoan(HttpServletRequest httpServletRequest,HttpServletResponse  httpServletResponse) throws ServletException, IOException {
		String id = httpServletRequest.getParameter("loanId");
		loanService.delete(Integer.valueOf(id));
		httpServletRequest.getRequestDispatcher("loans.go").forward(httpServletRequest, httpServletResponse);
	}
	
}
