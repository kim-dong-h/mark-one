package com.dhkim.markone.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

@Alias("commentVO")
public class CommentVO {

	private int idx;

	private int olympicBoardIdx;

	private String contents;

	private String name;

	private String pass;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getOlympicBoardIdx() {
		return olympicBoardIdx;
	}

	public void setOlympicBoardIdx(int olympicBoardIdx) {
		this.olympicBoardIdx = olympicBoardIdx;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


}
