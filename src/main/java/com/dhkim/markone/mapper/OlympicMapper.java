package com.dhkim.markone.mapper;

import java.util.List;

import com.dhkim.markone.vo.BoardVO;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OlympicMapper {
	
	public int selectOlympicBoardTotalCnt() throws Exception;
	
	public List<BoardVO> selectOlympicBoardList(BoardVO boardVO) throws Exception;
	
	public BoardVO selectOlympicBoardDetail(int idx) throws Exception;
	
	public void updateOlympicBoard(BoardVO boardVO) throws Exception;
	
	public void insertOlympicBoard(BoardVO boardVO) throws Exception;
	
	public void deleteOlympicBoard(BoardVO boardVO) throws Exception;
	
	
	
}
