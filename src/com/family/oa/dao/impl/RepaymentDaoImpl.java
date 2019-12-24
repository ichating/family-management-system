package com.family.oa.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.family.oa.dao.Dao;
import com.family.oa.dao.RepaymentDao;
import com.family.oa.entity.RepaymentEntity;
import com.family.oa.util.JdbcUtils;

public class RepaymentDaoImpl extends Dao<RepaymentEntity> implements RepaymentDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	@Override
	public void insert(String name,String repayment_amount,Date update_time,String repayment_user,String user_name,String remarks) {
		String sql = "insert into repayment(name,repayment_amount,repayment_time,update_time ,repayment_user,user_name,remarks) values(?,?,?,?,?,?,?) ";
		Date date = new Date(new java.util.Date().getTime());
		update(sql,name,new BigDecimal(repayment_amount),date,update_time,repayment_user,user_name,remarks);
	}

	@Override
	public List<RepaymentEntity> findAll(RepaymentEntity repayment) {
		String sql = "select * from  repayment where name like ? and repayment_user like ? and remarks like ?";
		return findAll(sql,repayment.getName(),repayment.getRepayment_user(),repayment.getRemarks());
	}

	@Override
	public void deleteRepayment(String repaymentId) {
		String sql = "delete  from  repayment where id=?";
		update(sql, repaymentId);
	}

}
