package com.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.board.domain.BoardDTO;

public interface BoardService {
	
	//해수어, 담수어 게시판을 위한 BoardService

	public boolean registerBoard(BoardDTO params);
	//담수어 게시글 업로드
	public boolean registerBoard(BoardDTO params, MultipartFile[] files);
	//담수어 파일 처리 된 게시글 업로드
	public BoardDTO getBoardDetail(Long idx);
	//담수어 게시글 상세 조회
	public boolean deleteBoard(Long idx);
	//담수어 게시글 삭제
	public List<BoardDTO> getBoardList(BoardDTO params);
	//담수어 게시글 리스트 조회
	
	
	public boolean registerBoardSaltwater(BoardDTO params);
	//해수어 게시글 업로드
	public boolean registerBoardSaltwater(BoardDTO params, MultipartFile[] files);
	//해수어 파일 처리 된 게시글 업로드
	public BoardDTO getBoardDetailSaltwater(Long idx);
	//해수어 게시글 상세 조회
	public boolean deleteBoardSaltwater(Long idx);
	//해수어 게시글 삭제
	public List<BoardDTO> getBoardListSaltwater(BoardDTO params);
	//해수어 게시글 리스트 조회


}
