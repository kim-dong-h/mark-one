package com.dhkim.markone.service;

import com.dhkim.markone.vo.CommentVO;

public interface CommentService {

	public void insertComment(CommentVO commentVO) throws Exception;
	
	public void updateComment(CommentVO commentVO) throws Exception;
	
	public void deleteComment(CommentVO commentVO) throws Exception;
	
}
