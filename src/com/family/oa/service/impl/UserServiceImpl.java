package com.family.oa.service.impl;

import java.util.List;

import com.family.oa.dao.impl.UserDaoImpl;
import com.family.oa.entity.UserEntity;
import com.family.oa.service.UserService;

public class UserServiceImpl implements UserService {

	UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public UserEntity login(String user_name, String user_password) {
		return userDao.login(user_name, user_password);
	}
	@Override
	public List<UserEntity> findAll() {
		return userDao.findAll();
	}
	@Override
	public void save(UserEntity user) {
		userDao.save(user);
	}
	@Override
	public UserEntity getOne(Integer id) {
		return userDao.getOne(id);
	}
	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}
	@Override
	public long getName(String name) {
		return userDao.getName(name);
	}
	@Override
	public void update(UserEntity user) {
		userDao.update(user);
	}
	@Override
	public List<UserEntity> findUserByNameOrTel(String name,String tel){
		return userDao.findByNameOrTel(name,tel);
	}
}
