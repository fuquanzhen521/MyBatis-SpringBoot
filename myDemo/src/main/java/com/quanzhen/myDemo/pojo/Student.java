package com.quanzhen.myDemo.pojo;

import java.util.Date;

/*
 * 作者:fuquanzhen
 * 类名:Student
 * 作用:student表的实体类
 * 日期:2019/09/23
 */
public class Student {

	// id
	private Long id;

	// 姓名
	private String name;

	// 生日
	private Date birthday;

	// 性别
	private Byte sex;

	// 学校id
	private Long schoolId;

	// 年级id
	private Long gradeId;

	// 班级id
	private Long classId;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}
