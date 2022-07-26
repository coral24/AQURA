package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.CommentDTO;
import com.board.domain.CommentTipDTO;

@Mapper
public interface CommentTipMapper {

	//물생활 꿀팀 mapper
	public int insertComment(String comment);
	public CommentTipDTO selectCommentDetail(int idx);
	public int updateComment(CommentTipDTO params);
	public int deleteComment(int idx);
	public List<CommentTipDTO> selectCommentList();
	public int selectCommentTotalCount(CommentTipDTO params);

}

