package com.board.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.board.domain.AttachDTO;
import com.board.domain.BoardDTO;
import com.board.mapper.AttachMapper;
import com.board.mapper.AttachSaltwaterMapper;
import com.board.mapper.BoardMapper;
import com.board.mapper.BoardSaltwaterMapper;
import com.board.paging.PaginationInfo;
import com.board.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	@Autowired
	private BoardSaltwaterMapper boardSaltwaterMapper;
	
	@Autowired
	private AttachSaltwaterMapper attachSaltwaterMapper;
	
	@Autowired
	private FileUtils fileUtils;

	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}
	//담수어 게시글 업로드

	
	
	@Override
	public boolean registerBoard(BoardDTO params, MultipartFile[] files) {
		int queryResult = 1;

		if (registerBoard(params) == false) {
			return false;
		}

		List<AttachDTO> fileList = null;
		try {
			fileList = fileUtils.uploadFiles(files, params.getIdx());
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (CollectionUtils.isEmpty(fileList) == false) {
			queryResult = attachMapper.insertAttach(fileList);
			if (queryResult < 1) {
				queryResult = 0;
			}
		}

		return (queryResult > 0);
	}
	//담수어 파일 처리 된 게시글 업로드

	

	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardMapper.selectBoardDetail(idx);
	}
	//담수어 게시글 상세 조회


	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;

		BoardDTO board = boardMapper.selectBoardDetail(idx);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(idx);
		}

		return (queryResult == 1) ? true : false;
	}
	//담수어 게시글 삭제

	@Override
	public List<BoardDTO> getBoardList(BoardDTO params) {
		List<BoardDTO> boardList = Collections.emptyList();

		int boardTotalCount = boardMapper.selectBoardTotalCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(boardTotalCount);

		params.setPaginationInfo(paginationInfo);

		if (boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList(params);
		}

		return boardList;
	}
	
	//담수어 게시글 리스트 조회
	
	
	@Override
	public boolean registerBoardSaltwater(BoardDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {
			queryResult = boardSaltwaterMapper.insertBoard(params);
		} else {
			queryResult = boardSaltwaterMapper.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}
	//해수어 게시글 업로드

	
	@Override
	public boolean registerBoardSaltwater(BoardDTO params, MultipartFile[] files) {
		int queryResult = 1;

		if (registerBoard(params) == false) {
			return false;
		}

		List<AttachDTO> fileList = null;
		try {
			fileList = fileUtils.uploadFiles(files, params.getIdx());
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (CollectionUtils.isEmpty(fileList) == false) {
			queryResult = attachSaltwaterMapper.insertAttach(fileList);
			if (queryResult < 1) {
				queryResult = 0;
			}
		}

		return (queryResult > 0);
	}
	//해수어 파일 처리 된 게시글 업로드

	

	@Override
	public BoardDTO getBoardDetailSaltwater(Long idx) {
		return boardSaltwaterMapper.selectBoardDetail(idx);
	}
	//해수어 게시글 상세 조회

	
	@Override
	public boolean deleteBoardSaltwater(Long idx) {
		int queryResult = 0;

		BoardDTO board = boardSaltwaterMapper.selectBoardDetail(idx);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardSaltwaterMapper.deleteBoard(idx);
		}

		return (queryResult == 1) ? true : false;
	}
	//해수어 게시글 삭제

	
	@Override
	public List<BoardDTO> getBoardListSaltwater(BoardDTO params) {
		List<BoardDTO> boardList = Collections.emptyList();

		int boardTotalCount = boardSaltwaterMapper.selectBoardTotalCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(boardTotalCount);

		params.setPaginationInfo(paginationInfo);

		if (boardTotalCount > 0) {
			boardList = boardSaltwaterMapper.selectBoardList(params);
		}

		return boardList;
	}
	//해수어 게시글 리스트 조회



}