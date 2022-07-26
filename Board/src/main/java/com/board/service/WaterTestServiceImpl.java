package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.WaterTestDTO;
import com.board.mapper.WaterTestMapper;

@Service
public class WaterTestServiceImpl implements WaterTestService{
	
	@Autowired
	private WaterTestMapper waterTestMapper;
	
	@Override
	public void insertTest(WaterTestDTO params) {
		waterTestMapper.insertTest(params);
	}
	//물생활 테스트 점수 db입력

	@Override
	public double getAverageTest() {
		
		double avg=waterTestMapper.getAverageTest();
		return avg;
	}
	//물생활 테스트 평균 조회

	@Override
	public void insertTotal(int total) {
		waterTestMapper.insertTotal(total);
	}
	//물생활 테스트 총점 db입력

	@Override
	public int getMyScore() {
		int score=waterTestMapper.getMyScore();
		return score;
	}
	//물생활 테스트 내 점수 조회

	@Override
	public int getMember() {
		int member=waterTestMapper.getMember();
		return member;
	}
	//물생활 테스트 전체 참가 인원 조회

	@Override
	public int getMaxScore() {
		int max=waterTestMapper.getMaxScore();
		return max;
	}
	//물생활 테스트 최고점 조회

	@Override
	public int getMinScore() {
		int min=waterTestMapper.getMinScore();
		return min;
	}
	//물생활 테스트 최저점 조회

	@Override
	public double getScoreAvg() {
		double avg=waterTestMapper.getScoreAvg();
		return avg;
	}
	//물생활 테스트 전체 평균 조회

}
