package com.family.oa.dao;

import java.sql.Date;
import java.util.List;

import com.family.oa.entity.RepaymentEntity;

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
	public List<RepaymentEntity> findAll(RepaymentEntity repayment);
	/**
	 * 删除记录
	 * @param repaymentId
	 * @return
	 */
	public void deleteRepayment(String repaymentId);
}
