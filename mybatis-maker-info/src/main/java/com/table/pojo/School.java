package com.table.pojo;

public class School {

	private long id;
	private String name;
	private Boolean jbw;
	private Boolean eyy;

	// 无参构造器
	public School() {
	}

	// 有参构造器
	public School(long id, String name, Boolean jbw, Boolean eyy) {
		this.id = id;
		this.name = name;
		this.jbw = jbw;
		this.eyy = eyy;
	}

	public School(String name, Boolean jbw, Boolean eyy) {
		this.name = name;
		this.jbw = jbw;
		this.eyy = eyy;
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

	public Boolean getJbw() {
		return jbw;
	}

	public void setJbw(Boolean jbw) {
		this.jbw = jbw;
	}

	public Boolean getEyy() {
		return eyy;
	}

	public void setEyy(Boolean eyy) {
		this.eyy = eyy;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", jbw=" + jbw + ", eyy=" + eyy + "]";
	}
}
