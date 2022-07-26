package com.board.domain;

public class CommentTipDTO {
	//물생활 꿀팁 페이지를 위한 CommentTipDTO

	private int idx;
	private String content;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CommentTipDTO [idx=" + idx + ", content=" + content + "]";
	}
	
	
	
	
	
}
