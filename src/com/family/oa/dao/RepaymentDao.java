package com.family.oa.dao;

import java.sql.Date;
import java.util.List;

import com.family.oa.entity.RepaymentEntity;
import com.family.oa.entity.UserEntity;

/**
 * 还款接口
 * @author Jole
 *
 */
public interface RepaymentDao {

	/**
	 * 添加还款记录
	 */
	public void insert(String name,String repayment_amount,Date update_time,String repayment_user,String user_name,String remarks);
	
	/**
	 * 查询全部记录
	 * @return
	 */
	public List<RepaymentEntity> findAll(int currentPage, int rows,RepaymentEntity repayment);
	/**
	 * 删除记录
	 * @param repaymentId
	 * @return
	 */
	public void deleteRepayment(String repaymentId);
	
	/** 查询当前页面的所有数据*/
    List<RepaymentEntity> findUserByPage(int currentPage, int rows);
    
	/** 总条数*/
    int findTotalCount();
}
