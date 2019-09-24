package com.quanzhen.myDemo.pojo;

/*
 * 作者:fuquanzhen
 * 类名:Class
 * 作用:class表的实体类
 * 日期:2019/09/23
 */
public class ClassInfo {

	// id
	private Long id;

	// 姓名
	private String name;

	// 学校id
	private Long schooId;

	// 年级id
	private Long gradeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSchooId() {
		return schooId;
	}

	public void setSchooId(Long schooId) {
		this.schooId = schooId;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

}
