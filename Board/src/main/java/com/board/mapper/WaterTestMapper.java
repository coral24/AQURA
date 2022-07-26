package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.WaterTestDTO;

@Mapper
public interface WaterTestMapper {
	
	//물생활 test mapper
	
	public void insertTest(WaterTestDTO params);
	public double getAverageTest();
	public void insertTotal(int total);
	public int getMyScore();
	public int getMember();
	public int getMaxScore();
	public int getMinScore();
	public double getScoreAvg();

}
