package com.table.pojo;

import java.sql.Date;

public class Student {

	private long id;
	private String name;
	private Date birthday;
	private Byte sex;
	private long sch_id;
	private long gra_id;
	private long cla_id;

	// 无参构造器
	public Student() {
	}

	// 有参构造器
	public Student(long id, String name, Date birthday, Byte sex, long sch_id, long gra_id, long cla_id) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.sch_id = sch_id;
		this.gra_id = gra_id;
		this.cla_id = cla_id;
	}

	public Student(String name, Date birthday, Byte sex, long sch_id, long gra_id, long cla_id) {
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.sch_id = sch_id;
		this.gra_id = gra_id;
		this.cla_id = cla_id;
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

	public long getCla_id() {
		return cla_id;
	}

	public void setCla_id(long cla_id) {
		this.cla_id = cla_id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", sex=" + sex + ", sch_id=" + sch_id
				+ ", gra_id=" + gra_id + ", cla_id=" + cla_id + "]";
	}
}
