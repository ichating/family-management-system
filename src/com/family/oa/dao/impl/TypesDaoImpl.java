package com.family.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.family.oa.dao.Dao;
import com.family.oa.dao.TypesDao;
import com.family.oa.entity.TypesEntity;
import com.family.oa.util.JdbcUtils;

public class TypesDaoImpl extends Dao<TypesEntity> implements TypesDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public List<TypesEntity> findAll() {
		List<TypesEntity> typesList = new ArrayList<TypesEntity>();
		try {
		connection = JdbcUtils.getConnection();
		String sql = "select id,name,remark from types ";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery(sql);
		while(resultSet.next()) {
			TypesEntity type = new TypesEntity();
			type.setId(resultSet.getInt("id"));
			type.setName(resultSet.getString("name"));
			type.setRemark(resultSet.getString("remark"));
			typesList.add(type);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);;
		}
		return typesList;
	}
}
