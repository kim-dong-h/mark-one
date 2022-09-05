package com.dhkim.markone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhkim.markone.service.CommentService;
import com.dhkim.markone.vo.CommentVO;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping(value = "/posts")
	public String olympicBoardInsert(@RequestBody CommentVO vo) throws Exception {

		try {
			commentService.insertComment(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

		return "S";
	}

	@PutMapping(value = "/posts")
	public String olympicBoardUpdate(@RequestBody CommentVO vo) throws Exception {

		try {
			commentService.updateComment(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

		return "S";
	}

	@DeleteMapping(value = "/posts/{idx}")
	public String olympicBoardDelete(@PathVariable("idx") int idx) throws Exception {

		try {
			CommentVO vo = new CommentVO();
			vo.setIdx(idx);
			commentService.deleteComment(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

		return "S";
	}

}
