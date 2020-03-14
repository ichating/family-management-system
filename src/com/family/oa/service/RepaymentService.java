package com.family.oa.service;

import java.sql.Date;
import java.util.List;

import com.family.oa.entity.RepaymentEntity;

public interface RepaymentService {

	public void insert(String name,String repayment_amount,Date update_time,String repayment_user,String user_name,String remarks);
	
	public List<RepaymentEntity> findAll(RepaymentEntity repayment);
	
	public void deleteRepayment(String repaymentId);
}
