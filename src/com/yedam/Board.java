package com.yedam;

import java.io.Serializable;

public class Board implements Serializable{
	int wriNo;
	String title;
	String content;
	String name;
	
	
	Board(){
		
	}


	public Board(int wriNo, String title, String content, String name) {
		this.wriNo = wriNo;
		this.title = title;
		this.content = content;
		this.name = name;
	}


	


	public int getWriNo() {
		return wriNo;
	}


	public void setWriNo(int wriNo) {
		this.wriNo = wriNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return " [게시글번호=" + wriNo + ", 제목=" + title + ", 내용=" + content + ", 작성자" + name + "]";
	}
	
	
	
	
}
