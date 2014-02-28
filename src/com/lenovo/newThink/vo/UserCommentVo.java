package com.lenovo.newThink.vo;

public class UserCommentVo {

	private long id;
	
	private long userid;
	
	private long newThinkId;
	
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getNewThinkId() {
		return newThinkId;
	}

	public void setNewThinkId(long newThinkId) {
		this.newThinkId = newThinkId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
