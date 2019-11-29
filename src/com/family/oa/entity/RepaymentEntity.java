package com.family.oa.entity;

import java.math.BigDecimal;
import java.sql.Date;
/**
 * 还款实体类
 * @author Jole
 *
 */
public class RepaymentEntity {
	
	/** 还款标识*/
	private Integer id;
	
	/** 贷款机构名称（以后换成贷款机构标识）*/
	private String name;
	
	/** 还款金额 */
	private BigDecimal repayment_amount;

	/** 支付日期 */
	private Date update_time;
	
	/** 记账日期 */
	private Date repayment_time;
	
	/**记账人 */
	private String user_name;
	
	/**支付人 */
	private String repayment_user;
	
	/** 描述*/
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		if(name==null) {
			name ="%%";
		}else {
			name="%"+name+"%";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRepayment_amount() {
		return repayment_amount;
	}

	public void setRepayment_amount(BigDecimal repayment_amount) {
		this.repayment_amount = repayment_amount;
	}

	public Date getRepayment_time() {
		return repayment_time;
	}

	public void setRepayment_time(Date repayment_time) {
		this.repayment_time = repayment_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getRemarks() {
		if(remarks==null) {
			remarks="%%";
		}else {
			remarks="%"+remarks+"%";
		}
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getRepayment_user() {
		if(repayment_user==null) {
			repayment_user="%%";
		}else {
			repayment_user="%"+repayment_user+"%";
		}
		return repayment_user;
	}

	public void setRepayment_user(String repayment_user) {
		this.repayment_user = repayment_user;
	}

	
}
