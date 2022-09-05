package com.dhkim.markone.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

@Alias("boardVO")
public class BoardVO {

	private int idx;

	private String title;

	private String contents;

	private String fileName;

	private String fileUrl;

	private String insertDt;

	private String updateDt;

	private String name;

	private String pass;

	private String secretMode;

	private String contentFeel;

	private int clickRate;

	private int age;

	private int gender;

	private int paging;

	private int setPaging;

	private String searchName;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(String insertDt) {
		this.insertDt = insertDt;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
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

	public String getSecretMode() {
		return secretMode;
	}

	public void setSecretMode(String secretMode) {
		this.secretMode = secretMode;
	}

	public String getContentFeel() {
		return contentFeel;
	}

	public void setContentFeel(String contentFeel) {
		this.contentFeel = contentFeel;
	}

	public int getClickRate() {
		return clickRate;
	}

	public void setClickRate(int clickRate) {
		this.clickRate = clickRate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getPaging() {
		return paging;
	}

	public void setPaging(int paging) {
		this.paging = paging;
	}

	public int getSetPaging() {
		return setPaging;
	}

	public void setSetPaging(int setPaging) {
		this.setPaging = setPaging;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
