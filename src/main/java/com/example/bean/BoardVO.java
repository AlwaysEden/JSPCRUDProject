package com.example.bean;

import java.util.Date;

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String category;
	private String attachment;
	private Date regdate;
	private Date lastUpdate;
	private int cnt;

	public String getCategory() {
		return category;
	}

	public String getAttachment() {
		return attachment;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
