package com.family.oa.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.family.oa.dao.impl.UserDaoImpl;
import com.family.oa.entity.UserEntity;

public class UserDaoImplTest {
	
	UserDaoImpl userDao = new UserDaoImpl();

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		UserEntity user = new UserEntity();
		List<UserEntity> userAll = userDao.findAll(user);
		System.out.println(userAll);
	}

	@Test
	public void testSave() {
		UserEntity user = new UserEntity();
		user.setUser_name("zs");
		user.setUser_password("123");
		userDao.save(user);
	}

	@Test
	public void testGetOne() {
		UserEntity one = userDao.getOne(1);
		System.out.println(one);
	}

	@Test
	public void testDelete() {
		userDao.delete(4);
	}

	@Test
	public void testGetName() {
		long countNum = userDao.getName("sa");
		System.out.println(countNum);
	}

}
