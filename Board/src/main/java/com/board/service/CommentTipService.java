package com.board.service;

import java.util.List;

import com.board.domain.CommentTipDTO;

public interface CommentTipService {

	public void registerComment(String comment);
	//물생활 꿀팁 db입력
	public List<CommentTipDTO> getCommentList();
	//물생활 꿀팁 list 조회
}
