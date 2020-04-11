package com.family.oa.service;

import java.sql.Date;
import java.util.List;

import com.family.oa.entity.PageBean;
import com.family.oa.entity.RepaymentEntity;
import com.family.oa.entity.UserEntity;

public interface RepaymentService {

	public void insert(String name,String repayment_amount,Date update_time,String repayment_user,String user_name,String remarks);
	
	public PageBean<RepaymentEntity> findAll(int currentPage, int rows,RepaymentEntity repayment);
	
	public void deleteRepayment(String repaymentId);
	/**
	 * 分页查询所有用户
	 * @param currentPage
	 * @param rows
	 * @return
	 */
	PageBean<RepaymentEntity> findUserByPage(int currentPage, int rows);
}
