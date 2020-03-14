package com.family.oa.dao;

import java.util.List;

import com.family.oa.entity.LoanEntity;

public interface LoanDao {

	public List<LoanEntity> findAll(LoanEntity loan);
	
	public void save(LoanEntity loan);

	public LoanEntity getOne(Integer id);
	
	public void delete(Integer id);
	
	public long getName(String name);
	
	public void update(LoanEntity loan);
}
