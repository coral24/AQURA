package com.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.CommentTipDTO;
import com.board.mapper.CommentTipMapper;

@Service
public class CommentTipServiceImpl implements CommentTipService{

	@Autowired
	private CommentTipMapper commentTipMapper;
	
	@Override
	public void registerComment(String comment) {
		
		commentTipMapper.insertComment(comment);
		
	}
	//물생활 꿀팁 db입력

	
	@Override
	public List<CommentTipDTO> getCommentList() {
		List<CommentTipDTO> commentList = commentTipMapper.selectCommentList();
	
		return commentList;
	}
	//물생활 꿀팁 list 조회

}
