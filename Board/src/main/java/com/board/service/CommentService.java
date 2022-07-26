package com.board.service;

import java.util.List;

import com.board.domain.CommentDTO;

public interface CommentService {

	public boolean registerComment(CommentDTO params);
	//담수어 댓글 생성, 조회
	public boolean deleteComment(Long idx);
	//담수어 댓글 삭제
	public List<CommentDTO> getCommentList(CommentDTO params);
	//담수어 댓글 리스트 조회
	
	public boolean registerCommentSaltwater(CommentDTO params);
	//해수어 댓글 생성, 조회
	public boolean deleteCommentSaltwater(Long idx);
	//해수어 댓글 삭제
	public List<CommentDTO> getCommentListSaltwater(CommentDTO params);
	//해수어 댓글 리스트 조회

}

