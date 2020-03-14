package com.family.oa.service.impl;

import java.util.List;

import com.family.oa.entity.LoanEntity;
import com.family.oa.service.LoanService;
import com.family.oa.dao.impl.LoanDaoImpl;

public class LoanServiceImpl implements LoanService {

	LoanDaoImpl LoanDaoImpl = new LoanDaoImpl();
	
	@Override
	public List<LoanEntity> findAll(LoanEntity loan) {
		return LoanDaoImpl.findAll(loan);
	}

	@Override
	public void save(LoanEntity loan) {
		LoanDaoImpl.save(loan);
	}

	@Override
	public LoanEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		LoanDaoImpl.delete(id);
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
