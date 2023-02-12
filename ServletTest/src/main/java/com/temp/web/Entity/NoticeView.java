package com.temp.web.Entity;

import java.sql.Timestamp;

public class NoticeView extends Notice {
	
	private int reCnt;
	

	
	public NoticeView() {
		super();
	}

	public NoticeView(int cd, String title, Timestamp createdDt, int userCd, int likeCnt, String contents, boolean pub, int reCnt) {
		super(cd, title, createdDt, userCd, likeCnt, contents, pub);
		this.reCnt = reCnt;
	}

	public int getReCnt() {
		return reCnt;
	}

	public void setReCnt(int reCnt) {
		this.reCnt = reCnt;
	}
}
