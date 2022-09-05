package com.dhkim.markone.service;

import java.util.Map;

import com.dhkim.markone.vo.BoardVO;


public interface OlympicService {

	public int selectOlympicBoardTotalCnt() throws Exception;
	
	public Map<String, Object> selectOlympicBoardList(BoardVO boardVO) throws Exception;
	
	public Map<String, Object> selectOlympicBoardDetail(int idx) throws Exception;
	
	public void updateOlympicBoard(BoardVO boardVO) throws Exception;
	
	public void insertOlympicBoard(BoardVO boardVO) throws Exception;
	
	public void deleteOlympicBoard(BoardVO boardVO) throws Exception;
	
}
