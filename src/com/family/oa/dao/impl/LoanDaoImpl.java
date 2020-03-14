package com.family.oa.dao.impl;

import java.util.List;

import com.family.oa.dao.Dao;
import com.family.oa.dao.LoanDao;
import com.family.oa.entity.LoanEntity;

public class LoanDaoImpl extends Dao<LoanEntity> implements LoanDao {

	@Override
	public List<LoanEntity> findAll(LoanEntity loan) {
		String sql = "select * from loan where user like ? and types like ? and remark like ?";
		return findAll(sql,loan.getUser(),loan.getTypes(),loan.getRemark());
	}

	@Override
	public void save(LoanEntity loan) {
		String sql ="insert into loan(user,types,inMoney,repaymentDay,repaymentInDate,repaymentOutDate,outMoney,remark,repayment_time,user_name) values(?,?,?,?,?,?,?,?,?,?)";
		update(sql,loan.getUser().substring(1, loan.getUser().length()-3),loan.getTypes().substring(1, loan.getTypes().length()-3),loan.getInMoney(),loan.getRepaymentDay(),loan.getRepaymentInDate(),loan.getRepaymentOutDate(),loan.getOutMoney(),loan.getRemark().substring(1, loan.getRemark().length()-3),loan.getRepayment_time(),loan.getUser_name());
	}

	@Override
	public LoanEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete  from  loan where id=?";
		update(sql,id);
	}

	@Override
	public long getName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(LoanEntity loan) {
		// TODO Auto-generated method stub

	}

}
