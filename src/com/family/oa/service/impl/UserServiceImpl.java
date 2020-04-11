package com.family.oa.service.impl;

import java.util.List;

import com.family.oa.dao.impl.UserDaoImpl;
import com.family.oa.entity.PageBean;
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
	public PageBean<UserEntity> findUserByNameOrTel(int currentPage, int rows,String name,String tel){
		PageBean<UserEntity> pageBean = new PageBean<UserEntity>();
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int totalCount = userDao.findTotalCount();
        //计算总页数
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pageBean.setTotalPage(totalPage);
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        List<UserEntity> list = userDao.findByNameOrTel(currentPage, rows,name,tel);

        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setList(list);
        return pageBean;
	}
   @Override
    public PageBean<UserEntity> findUserByPage(int currentPage, int rows) {
        PageBean<UserEntity> pageBean = new PageBean<UserEntity>();
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int totalCount = userDao.findTotalCount();
        //计算总页数
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pageBean.setTotalPage(totalPage);
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        List<UserEntity> list = userDao.findUserByPage(currentPage, rows);

        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setList(list);

        return pageBean;
    }
}
