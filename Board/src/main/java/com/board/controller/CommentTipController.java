package com.board.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.board.domain.CommentTipDTO;
import com.board.service.CommentTipService;

@Controller
public class CommentTipController {
	
	@Autowired
	private CommentTipService commentTipService;
	
	
	
	@RequestMapping("/comment")
	public String comment(@RequestParam("comment") String comment, Model model){
		model.addAttribute("id", comment); 
		System.out.println(comment);
		commentTipService.registerComment(comment);
		return "board/index";
    } 
	//물생활 꿀팁 공유 페이지 내용 insert

	
	@GetMapping("/commentTip")
	public String commentList( Model model) {
		List<CommentTipDTO> commentList = commentTipService.getCommentList();
	    model.addAttribute("commentList", commentList );  
	    return "board/guide";
	 }
	//물생활 꿀팁 공유 페이지 list view

	

}
