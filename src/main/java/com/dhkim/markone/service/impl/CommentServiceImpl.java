package com.dhkim.markone.service.impl;

import com.dhkim.markone.mapper.CommentMapper;
import com.dhkim.markone.service.CommentService;
import com.dhkim.markone.vo.CommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commnetMapper;
	
	@Override
	public void insertComment(CommentVO commentVO) throws Exception {
		commnetMapper.insertComment(commentVO);

	}

	@Override
	public void updateComment(CommentVO commentVO) throws Exception {
		commnetMapper.updateComment(commentVO);
	}

	@Override
	public void deleteComment(CommentVO commentVO) throws Exception {
		commnetMapper.deleteComment(commentVO);
	}

}
