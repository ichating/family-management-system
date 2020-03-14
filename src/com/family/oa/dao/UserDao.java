package com.family.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.family.oa.entity.UserEntity;

public interface UserDao {

	/** 登录*/
	public UserEntity login(String user_name,String user_password);
	
	/** 查询所有用户
	 * @throws SQLException */
	public List<UserEntity> findAll();
	
	/** 添加用户*/
	public void save(UserEntity user);

	/** 通过用户ID,查询单个用户*/
	public UserEntity getOne(Integer id);
	
	/**通过用户ID，删除用户 */
	public void delete(Integer id);
	
	/** 返回和name相等的记录数*/
	public long getName(String name);
	
	/**通过用户ID，修改用户信息 */
	public void update(UserEntity user);
	
	/** 模糊查询*/
	public List<UserEntity> findByNameOrTel(String name,String tel);
}
