package com.board.service;

import com.board.domain.WaterTestDTO;

public interface WaterTestService {
	
	public void insertTest(WaterTestDTO params);
	//물생활 테스트 점수 db입력
	public double getAverageTest();
	//물생활 테스트 평균 조회
	public void insertTotal(int total);
	//물생활 테스트 총점 db입력
	public int getMyScore();
	//물생활 테스트 내 점수 조회
	public int getMember();
	//물생활 테스트 전체 참가 인원 조회
	public int getMaxScore();
	//물생활 테스트 최고점 조회
	public int getMinScore();
	//물생활 테스트 최저점 조회
	public double getScoreAvg();
	//물생활 테스트 전체 평균 조회
}
