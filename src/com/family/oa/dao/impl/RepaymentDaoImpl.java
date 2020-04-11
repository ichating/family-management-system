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
import com.family.oa.entity.UserEntity;
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
	public List<RepaymentEntity> findAll(int currentPage, int rows,RepaymentEntity repayment) {
		List<RepaymentEntity> repaymentList = new ArrayList<RepaymentEntity>();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from  repayment where 1=1 ");
			//3个条件
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()>0) {
				sb.append("and name like ?");
				sb.append("and repayment_user like ?");
				sb.append("and remarks like ?");
				sb.append("limit ?,?");
			}
			
			//只有Repayment_user、Remarks
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()>0) {
				sb.append("and repayment_user like ?");
				sb.append("and remarks like ?");
				sb.append("limit ?,?");
			}
			//只有Name、Remarks
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()>0) {
				sb.append("and name like ?");
				sb.append("and remarks like ?");
				sb.append("limit ?,?");
			}
			//只有Name、Repayment_user
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()==0) {
				sb.append("and name like ?");
				sb.append("and repayment_user like ?");
				sb.append("limit ?,?");
			}
			
			//只有Name
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()==0) {
				sb.append("and name like ?");
				sb.append("limit ?,?");
			}
			//只有Remarks
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()>0) {
				sb.append("and remarks like ?");
				sb.append("limit ?,?");
			}
			//只有Repayment_user
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()==0) {
				sb.append("and repayment_user like ?");
				sb.append("limit ?,?");
			}
			
			//没有条件
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()==0) {
				sb.append("limit ?,?");
			}
			
			
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(sb.toString());
			
			//1、3个条件
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()>0) {
				preparedStatement.setString(1, "%"+repayment.getName()+"%");
				preparedStatement.setString(2, "%"+repayment.getRepayment_user()+"%");
				preparedStatement.setString(3, "%"+repayment.getRemarks()+"%");
				preparedStatement.setInt(4, (currentPage - 1) * rows);
				preparedStatement.setInt(5, rows);
			}
			//2、只有Repayment_user、Remarks
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()>0) {
				preparedStatement.setString(1, "%"+repayment.getRepayment_user()+"%");
				preparedStatement.setString(2, "%"+repayment.getRemarks()+"%");
				preparedStatement.setInt(3, (currentPage - 1) * rows);
				preparedStatement.setInt(4, rows);
			}
			//只有Name、Remarks
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()>0) {
				preparedStatement.setString(1, "%"+repayment.getName()+"%");
				preparedStatement.setString(2, "%"+repayment.getRemarks()+"%");
				preparedStatement.setInt(3, (currentPage - 1) * rows);
				preparedStatement.setInt(4, rows);
			}
			//只有Name、Repayment_user
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()==0) {
				preparedStatement.setString(1, "%"+repayment.getName()+"%");
				preparedStatement.setString(2, "%"+repayment.getRepayment_user()+"%");
				preparedStatement.setInt(3, (currentPage - 1) * rows);
				preparedStatement.setInt(4, rows);
			}
			//只有Name
			if(repayment.getName().length()>0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()==0) {
				preparedStatement.setString(1, "%"+repayment.getName()+"%");
				preparedStatement.setInt(2, (currentPage - 1) * rows);
				preparedStatement.setInt(3, rows);
			}
			//只有Remarks
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()>0) {
				preparedStatement.setString(1, "%"+repayment.getRemarks()+"%");
				preparedStatement.setInt(2, (currentPage - 1) * rows);
				preparedStatement.setInt(3, rows);
			}
			//只有Repayment_user
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()>0 && repayment.getRemarks().length()==0) {
				preparedStatement.setString(1, "%"+repayment.getRepayment_user()+"%");
				preparedStatement.setInt(2, (currentPage - 1) * rows);
				preparedStatement.setInt(3, rows);
			}
			
			//没有条件
			if(repayment.getName().length()==0 && repayment.getRepayment_user().length()==0 && repayment.getRemarks().length()==0) {
				preparedStatement.setInt(1, (currentPage - 1) * rows);
				preparedStatement.setInt(2, rows);
			}

			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				RepaymentEntity repayments = new RepaymentEntity();
				repayments.setId(resultSet.getInt("id"));
				repayments.setName(resultSet.getString("name"));
				repayments.setRemarks(resultSet.getString("remarks"));
				repayments.setRepayment_amount(resultSet.getBigDecimal("repayment_amount"));
				repayments.setRepayment_time(resultSet.getDate("repayment_time"));
				repayments.setRepayment_user(resultSet.getString("repayment_user"));
				repayments.setUpdate_time(resultSet.getDate("update_time"));
				repayments.setUser_name(resultSet.getString("user_name"));
				repaymentList.add(repayments);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtils.releaseConnection(connection);;
			}
		return repaymentList;
	}

	@Override
	public void deleteRepayment(String repaymentId) {
		String sql = "delete  from  repayment where id=?";
		update(sql, repaymentId);
	}
	
	@Override
    public List<RepaymentEntity> findUserByPage(int currentPage, int rows) {
		List<RepaymentEntity> repaymentList = new ArrayList<RepaymentEntity>();
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select * from repayment limit ?,?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, (currentPage - 1) * rows);
		preparedStatement.setInt(2, rows);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			RepaymentEntity repayment = new RepaymentEntity();
			repayment.setId(resultSet.getInt("id"));
			repayment.setName(resultSet.getString("name"));
			repayment.setRemarks(resultSet.getString("remarks"));
			repayment.setRepayment_amount(resultSet.getBigDecimal("repayment_amount"));
			repayment.setRepayment_time(resultSet.getDate("repayment_time"));
			repayment.setRepayment_user(resultSet.getString("repayment_user"));
			repayment.setUpdate_time(resultSet.getDate("update_time"));
			repayment.setUser_name(resultSet.getString("user_name"));
			repaymentList.add(repayment);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);;
		}
		return repaymentList;
    }

    @Override
    public int findTotalCount() {
    	int count = 0;
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select count(*) from repayment ";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			count = resultSet.getInt(1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);;
		}
		return count;
    }

}
