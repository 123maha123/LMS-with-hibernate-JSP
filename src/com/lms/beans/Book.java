package com.lms.beans;

public class Book {
	
	private String refID;
	private String title;
	private String isbn_no;
	private String member_ID;
	private String issue_Date;
	private String due_Date;
	private String category;
	private String status;
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRefID() {
		return refID;
	}
	
	public void setRefID(String refID) {
		this.refID = refID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIsbn_no() {
		return isbn_no;
	}
	
	public void setIsbn_no(String isbn_no) {
		this.isbn_no = isbn_no;
	}
	
	public String getMember_ID() {
		return member_ID;
	}
	
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	
	public String getIssue_Date() {
		return issue_Date;
	}
	
	public void setIssue_Date(String issue_Date) {
		this.issue_Date = issue_Date;
	}
	
	public String getDue_Date() {
		return due_Date;
	}
	
	public void setDue_Date(String due_Date) {
		this.due_Date = due_Date;
	}


}
