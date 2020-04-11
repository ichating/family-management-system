package com.family.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.family.oa.dao.Dao;
import com.family.oa.dao.UserDao;
import com.family.oa.entity.UserEntity;
import com.family.oa.util.JdbcUtils;

public class UserDaoImpl extends Dao<UserEntity> implements UserDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	@Override
	public UserEntity login(String user_name, String user_password) {
		UserEntity user = new UserEntity();
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select * from user where user_name=? and user_password=? ";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user_name);
		preparedStatement.setString(2, user_password);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			user.setId(resultSet.getInt("id"));
			user.setUser_name(resultSet.getString("user_name"));
			user.setName(resultSet.getString("name"));
			user.setUser_password(resultSet.getString("user_password"));
			user.setTel(resultSet.getString("tel"));
			user.setRemarks(resultSet.getString("remarks"));
			user.setUpdate_time(resultSet.getDate("update_time"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);;
		}
		return user;
	}

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select id,user_name,name,user_password,birthday,tel,remarks,update_time from user ";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			UserEntity user = new UserEntity();
			user.setId(resultSet.getInt("id"));
			user.setUser_name(resultSet.getString("user_name"));
			user.setName(resultSet.getString("name"));
			user.setUser_password(resultSet.getString("user_password"));
			user.setBirthday(resultSet.getDate("birthday"));
			user.setTel(resultSet.getString("tel"));
			user.setRemarks(resultSet.getString("remarks"));
			user.setUpdate_time(resultSet.getDate("update_time"));
			userList.add(user);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);;
		}
		return userList;
	}

	@Override
	public void save(UserEntity user) {
		String sql ="insert into user(user_name,name,user_password,birthday,tel,remarks,update_time) values(?,?,?,?,?,?,?)";
		update(sql,user.getUser_name(),user.getName(),user.getUser_password(),user.getBirthday(),user.getTel(),user.getRemarks(),user.getUpdate_time());
	}

	@Override
	public UserEntity getOne(Integer id) {
		String sql = "select * from user where id=?";
		return findOne(sql, id);
	}

	@Override
	public void delete(Integer id) {
		String sql ="delete from user where id=?";
		update(sql, id);
	}

	@Override
	public long getName(String name) {
		String sql ="select count(id) from user where user_name=?";
		return getValue(sql, name);
	}

	@Override
	public void update(UserEntity user) {
		String sql = "update user set user_name=? , name=? , user_password=? , birthday=? , tel=?,remarks=?,update_time=? where id=?";
		this.update(sql,user.getUser_name(),user.getName(),user.getUser_password(),user.getBirthday(),user.getTel(),user.getRemarks(),user.getUpdate_time(),user.getId());
	}

	
	@Override
	public List<UserEntity> findByNameOrTel(int currentPage, int rows,String name,String tel){
		List<UserEntity> userList = new ArrayList<UserEntity>();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select id,user_name,name,user_password,birthday,tel,remarks,update_time from user where  1=1 ");
			if(name.length()>0&& tel.length()>0) {
				sb.append("and name like ?");
				sb.append("and tel like ?");
				sb.append("limit ?,?");
			}
			if(name.length()>0&& tel.length()==0) {
				sb.append("and name like ?");
				sb.append("limit ?,?");
			}
			if(name.length()==0&& tel.length()>0) {
				sb.append("and tel like ?");
				sb.append("limit ?,?");
			}
			if(name.length()==0&& tel.length()==0) {
				sb.append("limit ?,?");
			}
			
			
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(sb.toString());
			if(name.length()>0&& tel.length()>0) {
				preparedStatement.setString(1, "%"+name+"%");
				preparedStatement.setString(2, "%"+tel+"%");
				preparedStatement.setInt(3, (currentPage - 1) * rows);
				preparedStatement.setInt(4, rows);
			}
			if(name.length()>0&& tel.length()==0) {
				preparedStatement.setString(1, "%"+name+"%");
				preparedStatement.setInt(2, (currentPage - 1) * rows);
				preparedStatement.setInt(3, rows);
			}
			if(name.length()==0&& tel.length()>0) {
				preparedStatement.setString(1, "%"+tel+"%");
				preparedStatement.setInt(2, (currentPage - 1) * rows);
				preparedStatement.setInt(3, rows);
			}
			if(name.length()==0&& tel.length()==0) {
				preparedStatement.setInt(1, (currentPage - 1) * rows);
				preparedStatement.setInt(2, rows);
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				UserEntity user = new UserEntity();
				user.setId(resultSet.getInt("id"));
				user.setUser_name(resultSet.getString("user_name"));
				user.setName(resultSet.getString("name"));
				user.setUser_password(resultSet.getString("user_password"));
				user.setBirthday(resultSet.getDate("birthday"));
				user.setTel(resultSet.getString("tel"));
				user.setRemarks(resultSet.getString("remarks"));
				user.setUpdate_time(resultSet.getDate("update_time"));
				userList.add(user);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtils.releaseConnection(connection);;
			}
		return userList;
	}
	
	@Override
    public List<UserEntity> findUserByPage(int currentPage, int rows) {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select * from user limit ?,?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, (currentPage - 1) * rows);
		preparedStatement.setInt(2, rows);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			UserEntity user = new UserEntity();
			user.setId(resultSet.getInt("id"));
			user.setUser_name(resultSet.getString("user_name"));
			user.setName(resultSet.getString("name"));
			user.setUser_password(resultSet.getString("user_password"));
			user.setBirthday(resultSet.getDate("birthday"));
			user.setTel(resultSet.getString("tel"));
			user.setRemarks(resultSet.getString("remarks"));
			user.setUpdate_time(resultSet.getDate("update_time"));
			userList.add(user);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);;
		}
		return userList;
    }

    @Override
    public int findTotalCount() {
    	int count = 0;
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select count(*) from user ";
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
