package com.temp.web.Entity;

import java.sql.Timestamp;


public class Notice {
	
	private int cd;
	private String title;
	private Timestamp createdDt;
	private int userCd;
	private int likeCnt;
	private String contents;
	private boolean pub;
	
	public Notice() {
		super();
	}
	public Notice(int cd, String title, Timestamp createdDt, int userCd, int likeCnt, String contents, boolean pub) {
		super();
		this.cd = cd;
		this.title = title;
		this.createdDt = createdDt;
		this.userCd = userCd;
		this.likeCnt = likeCnt;
		this.contents = contents;
		this.pub = pub;
	}
	
	public boolean isPub() {
		return pub;
	}
	public void setPub(boolean pub) {
		this.pub = pub;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}
	public int getUserCd() {
		return userCd;
	}
	public void setUserCd(int userCd) {
		this.userCd = userCd;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Notice [title=" + title + ", createdDt=" + createdDt + ", userCd=" + userCd + ", likeCnt=" + likeCnt
				+ ", contents=" + contents + "]";
	}
}
