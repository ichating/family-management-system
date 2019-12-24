package com.family.oa.entity;
/**
 * 类型
 * @author Jole
 */
public class TypesEntity {
	/** 类型ID*/
	private Integer id;
	/** 类型名称*/
	private String name;
	/** 备注*/
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
