package com.family.oa.service.impl;

import java.sql.Date;
import java.util.List;

import com.family.oa.dao.RepaymentDao;
import com.family.oa.dao.impl.RepaymentDaoImpl;
import com.family.oa.entity.PageBean;
import com.family.oa.entity.RepaymentEntity;
import com.family.oa.entity.UserEntity;
import com.family.oa.service.RepaymentService;

public class RepaymentServiceImpl implements RepaymentService {

	RepaymentDao dao = new RepaymentDaoImpl();
	 
	@Override
	public void insert(String name,String repayment_amount,Date update_time,String repayment_user,String user_name,String remarks) {
		dao.insert(name, repayment_amount,update_time,repayment_user,user_name, remarks);
	}

	@Override
	public PageBean<RepaymentEntity> findAll(int currentPage, int rows,RepaymentEntity repayment) {
		PageBean<RepaymentEntity> pageBean = new PageBean<RepaymentEntity>();
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int totalCount = dao.findTotalCount();
        //计算总页数
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pageBean.setTotalPage(totalPage);
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        List<RepaymentEntity> list = dao.findAll(currentPage, rows,repayment);

        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setList(list);
        return pageBean;
	}

	@Override
	public void deleteRepayment(String repaymentId) {
		dao.deleteRepayment(repaymentId);
	}

	 @Override
	    public PageBean<RepaymentEntity> findUserByPage(int currentPage, int rows) {
	        PageBean<RepaymentEntity> pageBean = new PageBean<RepaymentEntity>();
	        if (currentPage <= 0) {
	            currentPage = 1;
	        }
	        int totalCount = dao.findTotalCount();
	        //计算总页数
	        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
	        pageBean.setTotalPage(totalPage);
	        if (currentPage > totalPage) {
	            currentPage = totalPage;
	        }
	        List<RepaymentEntity> list = dao.findUserByPage(currentPage, rows);

	        pageBean.setTotalCount(totalCount);
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setRows(rows);
	        pageBean.setList(list);

	        return pageBean;
	    }

}
