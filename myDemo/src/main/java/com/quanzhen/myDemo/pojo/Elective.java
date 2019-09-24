package com.quanzhen.myDemo.pojo;

/*
 * 作者:fuquanzhen
 * 类名:Elective
 * 作用:elective表的实体类
 * 日期:2019/09/23
 */
public class Elective {

	// id
	private Long id;

	// 学生id
	private Long studentId;

	// 课程id
	private Long courseId;

	// 教师id
	private Long teacherId;

	// 成绩
	private int score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
