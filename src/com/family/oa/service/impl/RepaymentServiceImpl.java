package com.family.oa.service.impl;

import java.sql.Date;
import java.util.List;

import com.family.oa.dao.RepaymentDao;
import com.family.oa.dao.impl.RepaymentDaoImpl;
import com.family.oa.entity.RepaymentEntity;
import com.family.oa.service.RepaymentService;

public class RepaymentServiceImpl implements RepaymentService {

	RepaymentDao dao = new RepaymentDaoImpl();
	 
	@Override
	public void insert(String name,String repayment_amount,Date update_time,String repayment_user,String user_name,String remarks) {
		dao.insert(name, repayment_amount,update_time,repayment_user,user_name, remarks);
	}

	@Override
	public List<RepaymentEntity> findAll(RepaymentEntity repayment) {
		return dao.findAll(repayment);
	}

	@Override
	public void deleteRepayment(String repaymentId) {
		dao.deleteRepayment(repaymentId);
	}

}
