package com.quanzhen.myDemo.pojo;

/*
 * 作者:fuquanzhen
 * 类名:School
 * 作用:school表的实体类
 * 日期:2019/09/23
 */
public class School {

	// id
	private Long id;

	// 姓名
	private String name;

	// 是否是985院校
	private Boolean jbw;

	// 是否是211院校
	private Boolean eyy;

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
