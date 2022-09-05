package com.dhkim.markone.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dhkim.markone.mapper.CommentMapper;
import com.dhkim.markone.mapper.OlympicMapper;
import com.dhkim.markone.service.OlympicService;
import com.dhkim.markone.vo.BoardVO;
import com.dhkim.markone.vo.CommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import net.sf.json.JSONArray;

@Service
public class OlympicServiceImpl implements OlympicService {

	@Autowired
	private OlympicMapper olympicMapper;
	
	@Autowired
	private CommentMapper commentMapper;

	
	@Override
	public int selectOlympicBoardTotalCnt() throws Exception {
		return olympicMapper.selectOlympicBoardTotalCnt();
	}


	@Override
	public Map<String, Object> selectOlympicBoardList(BoardVO boardVO) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pagingCnt = 10;
		int totalCnt = olympicMapper.selectOlympicBoardTotalCnt();
		
		int total = (int) Math.ceil((double) totalCnt / pagingCnt);
		
		int start = 1;
		int end = 5;

		if (total < 5) {
			end = total;
		} else {
			if (boardVO.getPaging() > 3) {
				if (boardVO.getPaging() + 2 > total) {
					start = boardVO.getPaging() - 3;
					end = boardVO.getPaging() + 1;
				} else {
					start = boardVO.getPaging() - 2;
					end = boardVO.getPaging() + 2;
				}
				if (boardVO.getPaging() == total) {
					start = boardVO.getPaging() - 4;
					end = boardVO.getPaging();
				}
			}
		}
		
		map.put("totalCnt", total);
		map.put("startPage", start);
		map.put("endPage", end);

		// data
		int p = (boardVO.getPaging() - 1) * pagingCnt;

		boardVO.setPaging(p);
		boardVO.setSetPaging(pagingCnt);
		
		List<BoardVO> listVO =  olympicMapper.selectOlympicBoardList(boardVO);
		
		JSONArray boardJsonArray = JSONArray.fromObject(listVO);
		
		map.put("boardVOList", boardJsonArray);
		
		return map;
	}

	@Override
	public Map<String, Object> selectOlympicBoardDetail(int idx) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		CommentVO vo = new CommentVO();
		vo.setOlympicBoardIdx(idx);
		
		
		resultMap.put("boardVO", olympicMapper.selectOlympicBoardDetail(idx));
		resultMap.put("commentVO", commentMapper.selectCommentList(vo));
		return resultMap;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED) // 직접 트랜잭션 선언 
	public void updateOlympicBoard(BoardVO boardVO) throws Exception {
		olympicMapper.updateOlympicBoard(boardVO);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED) // 직접 트랜잭션 선언 
	public void insertOlympicBoard(BoardVO boardVO) throws Exception {
		olympicMapper.insertOlympicBoard(boardVO);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED) // 직접 트랜잭션 선언 
	public void deleteOlympicBoard(BoardVO boardVO) throws Exception {
		
		CommentVO commentVO = new CommentVO();
		commentVO.setOlympicBoardIdx(boardVO.getIdx());
		commentMapper.deleteCommentAll(commentVO);
		
		olympicMapper.deleteOlympicBoard(boardVO);
	}

}
