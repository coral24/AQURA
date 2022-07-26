package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.board.service.WaterTestService;


@Controller
public class WaterTestController {
	
	@Autowired
	WaterTestService waterTestService;
	
	   @GetMapping(value = "/test")
	   public String test(){
		
		return "board/test";
	   }
	   //물생활 테스트 페이지

	
       @GetMapping("/multi")
	   public String multi(@RequestParam List<Integer> checkedValue){
      
       int sum=0;  
       for (int c : checkedValue) {
    	  
    	   sum+=c;
       }
       //물생활 테스트 결과 값 구하기
      
        
       System.out.println(sum);
       waterTestService.insertTotal(sum);
       
       if(sum==100) 
    	   return "board/testResult4";
       //테스트 결과가 100점이면 testResult4 
    	   
       
       else if(sum>=70&&sum<100)
        return "board/testResult3";
      //테스트 결과가 70점이상 100점 미만이면 testResult3
       
       else if(sum>=40&&sum<70)
    	   return "board/testResult2";
      //테스트 결과가 40점 이상 70점 미만이면 testResult3
       
       else
    	   return "board/testResult1";
     //테스트 결과가 40점 미만이면 testResult1
    }
	
	

    
		@RequestMapping("board/testScore")
		public String testScore(Model model) {
			int score;
			score=waterTestService.getMyScore();
			String num=Integer.toString(score);
			System.out.println(num);
			model.addAttribute("score",num);
			return "board/testScore";
		}
		//내 점수 확인 

		@RequestMapping("board/testMember")
		public String testMember(Model model) {
			int member;
			member=waterTestService.getMember();
			String num=Integer.toString(member);
			System.out.println(num);
			model.addAttribute("member",num);
			return "board/testMember";
		}
		//전체 테스트 참여 인원 확인 
    
		@RequestMapping("board/testMaxScore")
		public String testMaxScore(Model model) {
			int max;
			max=waterTestService.getMaxScore();
			String num=Integer.toString(max);
			System.out.println(num);
			model.addAttribute("max",num);
			return "board/testMaxScore";
		}
		//최고점 확인
    
		@RequestMapping("board/testMinScore")
		public String testMinScore(Model model) {
			int min;
			min=waterTestService.getMinScore();
			String num=Integer.toString(min);
			System.out.println(num);
			model.addAttribute("min",num);
			return "board/testMinScore";
		}
		//최저점 확인
    
    
		@RequestMapping("board/testAverage")
		public String testAverage(Model model) {
			double avg;
			avg=waterTestService.getScoreAvg();
			String num=Double.toString(avg);
			System.out.println(num);
			model.addAttribute("avg",num);
			return "board/testAverage";
		}
		//전체 평균 확인
    
    
	
	
}
