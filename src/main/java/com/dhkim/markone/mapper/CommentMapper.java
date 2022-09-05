package com.dhkim.markone.mapper;

import java.util.List;

import com.dhkim.markone.vo.CommentVO;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CommentMapper {

	public List<CommentVO> selectCommentList(CommentVO commentVO) throws Exception;
	
	public void insertComment(CommentVO commentVO) throws Exception;
	
	public void updateComment(CommentVO commentVO) throws Exception;
	
	public void deleteComment(CommentVO commentVO) throws Exception;
	
	public void deleteCommentAll(CommentVO commentVO) throws Exception;
	
	
}
