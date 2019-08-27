package com.table.pojo;

public class Elective {

	private long id;
	private long sid;
	private long cid;
	private long tid;
	private int score;

	// 无参构造器
	public Elective() {
	}

	// 有参构造器
	public Elective(long id, long sid, long cid, long tid, int score) {
		this.id = id;
		this.sid = sid;
		this.cid = cid;
		this.tid = tid;
		this.score = score;
	}

	public Elective(long sid, long cid, long tid, int score) {
		this.sid = sid;
		this.cid = cid;
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

	@Override
	public String toString() {
		return "Elective [id=" + id + ", sid=" + sid + ", cid=" + cid + ", tid=" + tid + ", score=" + score + "]";
	}
}
