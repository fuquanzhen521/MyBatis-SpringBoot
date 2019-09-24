package com.quanzhen.myDemo.pojo;

/*
 * 作者:fuquanzhen
 * 类名:Teacher
 * 作用:teacher表的实体类
 * 日期:2019/09/23
 */
public class Teacher {

	// id
	private Long id;

	// 姓名
	private String name;

	// 课程id
	private Long courseId;

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

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
