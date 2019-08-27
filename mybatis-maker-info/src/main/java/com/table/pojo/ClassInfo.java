package com.table.pojo;

public class ClassInfo {

	private long id;
	private String name;
	private long sch_id;
	private long gra_id;

	// 无参构造器
	public ClassInfo() {
	}

	// 有参构造器
	public ClassInfo(long id, String name, long sch_id, long gra_id) {
		this.id = id;
		this.name = name;
		this.sch_id = sch_id;
		this.gra_id = gra_id;
	}

	public ClassInfo(String name, long sch_id, long gra_id) {
		this.name = name;
		this.sch_id = sch_id;
		this.gra_id = gra_id;
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

	public long getSch_id() {
		return sch_id;
	}

	public void setSch_id(long sch_id) {
		this.sch_id = sch_id;
	}

	public long getGra_id() {
		return gra_id;
	}

	public void setGra_id(long gra_id) {
		this.gra_id = gra_id;
	}

	@Override
	public String toString() {
		return "ClassInfo [id=" + id + ", name=" + name + ", sch_id=" + sch_id + ", gra_id=" + gra_id + "]";
	}
}
