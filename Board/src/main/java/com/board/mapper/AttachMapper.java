package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.AttachDTO;

@Mapper
public interface AttachMapper {
	//담수어 게시판 파일 처리 mapper 
	
	public int insertAttach(List<AttachDTO> attachList);
	public AttachDTO selectAttachDetail(Long idx);
	public int deleteAttach(Long boardIdx);
	public List<AttachDTO> selectAttachList(Long boardIdx);
	public int selectAttachTotalCount(Long boardIdx);
}
