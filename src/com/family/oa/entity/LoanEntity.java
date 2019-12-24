package com.family.oa.entity;

import java.math.BigDecimal;
import java.sql.Date;
/**
 * 贷款实体类
 * @author Jole
 *
 */
public class LoanEntity {
	/** 贷款ID*/
	private Integer id;
	/** 贷款人*/
	private String user;
	/** 类型*/
	private String types;
	/** 贷款金额*/
	private BigDecimal inMoney;
	/** 期数*/
	private Integer repaymentDay;
	/** 贷款时间*/
	private Date repaymentInDate;
	/** 还款时间*/
	private Date repaymentOutDate;
	/** 还款金额*/
	private BigDecimal outMoney;
	/** 备注*/
	private String remark;
	/** 记账日期 */
	private Date repayment_time;
	/**记账人 */
	private String user_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		if(user==null) {
			user="%%";
		}else {
			user="%"+user+"%";
		}
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTypes() {
		if(types==null) {
			types="%%";
		}else {
			types="%"+types+"%";
		}
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public BigDecimal getInMoney() {
		return inMoney;
	}

	public void setInMoney(BigDecimal inMoney) {
		this.inMoney = inMoney;
	}

	public Integer getRepaymentDay() {
		return repaymentDay;
	}

	public void setRepaymentDay(Integer repaymentDay) {
		this.repaymentDay = repaymentDay;
	}

	public Date getRepaymentInDate() {
		return repaymentInDate;
	}

	public void setRepaymentInDate(Date repaymentInDate) {
		this.repaymentInDate = repaymentInDate;
	}

	public Date getRepaymentOutDate() {
		return repaymentOutDate;
	}

	public void setRepaymentOutDate(Date repaymentOutDate) {
		this.repaymentOutDate = repaymentOutDate;
	}

	public BigDecimal getOutMoney() {
		return outMoney;
	}

	public void setOutMoney(BigDecimal outMoney) {
		this.outMoney = outMoney;
	}

	public String getRemark() {
		if(remark==null) {
			remark = "%%";
		}else {
			remark = "%"+ remark +"%";
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
