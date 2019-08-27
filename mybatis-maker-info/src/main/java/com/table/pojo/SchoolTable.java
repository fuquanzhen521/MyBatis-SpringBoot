package com.table.pojo;

public class SchoolTable {

	private long id;

	private String name;

	private String jbw;

	private String eyy;

	public SchoolTable(long id, String name, String jiubawu, String eryiyi) {
		this.id = id;
		this.name = name;
		this.jbw = jiubawu;
		this.eyy = eryiyi;
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

	public String getJiubawu() {
		return jbw;
	}

	public void setJiubawu(String jiubawu) {
		this.jbw = jiubawu;
	}

	public String getEryiyi() {
		return eyy;
	}

	public void setEryiyi(String eryiyi) {
		this.eyy = eryiyi;
	}

}
