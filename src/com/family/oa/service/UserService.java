package com.family.oa.service;

import java.util.List;

import com.family.oa.entity.UserEntity;

public interface UserService {

	public UserEntity login(String user_name,String user_password);
	
	public List<UserEntity> findAll();
	
	public void save(UserEntity user);

	public UserEntity getOne(Integer id);
	
	public void delete(Integer id);
	
	/** 返回和name相等的记录数*/
	public long getName(String name);
	
	/**通过用户ID，修改用户信息 */
	public void update(UserEntity user);
	/**
	 * 模糊查询
	 * @param name
	 * @param tel
	 * @return
	 */
	public List<UserEntity> findUserByNameOrTel(String name,String tel);
}
