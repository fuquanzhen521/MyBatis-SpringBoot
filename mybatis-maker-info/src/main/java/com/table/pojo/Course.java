package com.table.pojo;

public class Course {

	private long id;
	private String name;

	// 无参构造器
	public Course() {
	}

	// 有参构造器
	public Course(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Course(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
