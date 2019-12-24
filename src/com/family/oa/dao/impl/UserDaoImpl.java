package com.family.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<UserEntity> findAll(UserEntity user) {
		String sql ="select id,user_name,name,user_password,birthday,tel,remarks,update_time from user where name like ?"+
					"and tel like ?";
		return findAll(sql,user.getName(),user.getTel());
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
		UserEntity oneUser = this.getOne(user.getId());
		String sql = "update user set user_name=? , name=? , user_password=? , birthday=? , tel=?,remarks=?,update_time=? where id=?";
		this.update(sql,user.getUser_name(),user.getName(),user.getUser_password(),user.getBirthday(),user.getTel(),user.getRemarks(),user.getUpdate_time(),user.getId());
	}

}
