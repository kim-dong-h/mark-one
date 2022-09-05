package com.dhkim.markone.controller;

import java.util.Map;

import com.dhkim.markone.service.OlympicService;
import com.dhkim.markone.vo.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.sf.json.JSONObject;

@RestController
@RequestMapping("/board")
public class OlympicBoardController {

	@Autowired
	private OlympicService olympicService;

	@GetMapping(value = "/list/{currentPage}")
	public JSONObject olympicBoardList(BoardVO boardVO, @PathVariable("currentPage") int currentPage) throws Exception {
		
		boardVO.setPaging(currentPage);
		
		Map<String, Object> result = olympicService.selectOlympicBoardList(boardVO);
		
		JSONObject resultVO = JSONObject.fromObject(result);
		
		return resultVO;
	}

	@GetMapping(value = "/detail/{idx}")
	public JSONObject olympicBoardDetail(@PathVariable("idx") int idx) throws Exception {

		Map<String, Object> result = olympicService.selectOlympicBoardDetail(idx);

		JSONObject resultVO = JSONObject.fromObject(result);

		return resultVO;
	}

	@PostMapping(value = "/posts")
	public String olympicBoardInsert(@RequestBody BoardVO vo) throws Exception {
		
		try {
			olympicService.insertOlympicBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		
		return "S";
	}

	@PutMapping(value = "/posts")
	public String olympicBoardUpdate(@RequestBody BoardVO vo) throws Exception {
		
		try {
			olympicService.updateOlympicBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		
		return "S";
	}

	@DeleteMapping(value = "/posts/{idx}")
	public String olympicBoardDelete(@PathVariable("idx") int idx) throws Exception {

		try {
			BoardVO vo = new BoardVO();
			vo.setIdx(idx);
			olympicService.deleteOlympicBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		
		return "S";
	}

}
