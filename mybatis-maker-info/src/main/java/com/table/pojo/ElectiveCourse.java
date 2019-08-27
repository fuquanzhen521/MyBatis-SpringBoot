package com.table.pojo;

public class ElectiveCourse {

	private long id;
	private long sid;
	private long cid;
	private String name;
	private long tid;
	private int score;

	// 无参构造器
	public ElectiveCourse() {
	}

	// 有参构造器
	public ElectiveCourse(long id, long sid, long cid, String name, long tid, int score) {
		this.id = id;
		this.sid = sid;
		this.cid = cid;
		this.name = name;
		this.tid = tid;
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
