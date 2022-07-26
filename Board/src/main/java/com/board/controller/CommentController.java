package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.CommentDTO;
import com.board.service.CommentService;
import com.google.gson.JsonObject;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value = { "/comments", "/comments/{idx}" }, method = { RequestMethod.POST, RequestMethod.PATCH })
	public JsonObject registerComment(@PathVariable(value = "idx", required = false) Long idx, @RequestBody final CommentDTO params) {
		JsonObject jsonObj = new JsonObject();
		System.out.println("hey?");
		try {
			boolean isRegistered = commentService.registerComment(params);
			jsonObj.addProperty("result", isRegistered);

		} catch (DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	//담수어 댓글 생성, 수정

	@GetMapping(value = "/comments/{boardIdx}")
	public List<CommentDTO> getCommentList(@PathVariable("boardIdx") Long boardIdx, @ModelAttribute("params") CommentDTO params) {
		List<CommentDTO> commentList = commentService.getCommentList(params);
		return commentList;
	}
	//담수어 댓글 리스트 조회
	
	
	@DeleteMapping(value = "/comments/{idx}")
	public JsonObject deleteComment(@PathVariable("idx") final Long idx) {

		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = commentService.deleteComment(idx);
			jsonObj.addProperty("result", isDeleted);

		} catch (DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	//담수어 댓글 삭제
	
	
	@RequestMapping(value = { "/comments/saltWater", "/comments/saltWater/{idx}" }, method = { RequestMethod.POST, RequestMethod.PATCH })
	public JsonObject registerCommentSaltwater(@PathVariable(value = "idx", required = false) Long idx, @RequestBody final CommentDTO params) {
		JsonObject jsonObj = new JsonObject();
System.out.println("hey?");
		try {
			boolean isRegistered = commentService.registerCommentSaltwater(params);
			jsonObj.addProperty("result", isRegistered);

		} catch (DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	//해수어 댓글 생성, 수정

	@GetMapping(value = "/comments/saltWater/{boardIdx}")
	public List<CommentDTO> getCommentListSaltwater(@PathVariable("boardIdx") Long boardIdx, @ModelAttribute("params") CommentDTO params) {
		List<CommentDTO> commentList = commentService.getCommentListSaltwater(params);
		return commentList;
	}
	//해수어 댓글 리스트 조회
	
	
	@DeleteMapping(value = "/comments/saltWater/{idx}")
	public JsonObject deleteCommentSaltwater(@PathVariable("idx") final Long idx) {

		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = commentService.deleteCommentSaltwater(idx);
			jsonObj.addProperty("result", isDeleted);

		} catch (DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	//해수어 댓글 삭제

}