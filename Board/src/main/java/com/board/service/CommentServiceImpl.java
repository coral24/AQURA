package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.CommentDTO;
import com.board.mapper.CommentMapper;
import com.board.mapper.CommentSaltwaterMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private CommentSaltwaterMapper commentSaltwaterMapper;

	@Override
	public boolean registerComment(CommentDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {
			queryResult = commentMapper.insertComment(params);
		} else {
			queryResult = commentMapper.updateComment(params);
		}

		return (queryResult == 1) ? true : false;
	}
	//담수어 댓글 생성, 조회

	@Override
	public boolean deleteComment(Long idx) {
		int queryResult = 0;

		CommentDTO comment = commentMapper.selectCommentDetail(idx);

		if (comment != null && "N".equals(comment.getDeleteYn())) {
			queryResult = commentMapper.deleteComment(idx);
		}

		return (queryResult == 1) ? true : false;
	}
	//담수어 댓글 삭제

	@Override
	public List<CommentDTO> getCommentList(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();

		int commentTotalCount = commentMapper.selectCommentTotalCount(params);
		if (commentTotalCount > 0) {
			commentList = commentMapper.selectCommentList(params);
		}

		return commentList;
	}
	//담수어 댓글 리스트 조회

	
	@Override
	public boolean registerCommentSaltwater(CommentDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {
			queryResult = commentSaltwaterMapper.insertComment(params);
		} else {
			queryResult = commentSaltwaterMapper.updateComment(params);
		}

		return (queryResult == 1) ? true : false;
	}
	//해수어 댓글 생성, 조회

	@Override
	public boolean deleteCommentSaltwater(Long idx) {
		int queryResult = 0;

		CommentDTO comment = commentSaltwaterMapper.selectCommentDetail(idx);

		if (comment != null && "N".equals(comment.getDeleteYn())) {
			queryResult = commentSaltwaterMapper.deleteComment(idx);
		}

		return (queryResult == 1) ? true : false;
	}
	//해수어 댓글 삭제

	@Override
	public List<CommentDTO> getCommentListSaltwater(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();

		int commentTotalCount = commentSaltwaterMapper.selectCommentTotalCount(params);
		if (commentTotalCount > 0) {
			commentList = commentSaltwaterMapper.selectCommentList(params);
		}

		return commentList;
	}
	//해수어 댓글 리스트 조회

}