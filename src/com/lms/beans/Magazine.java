package com.lms.beans;
public class Magazine {
private String refID;
private String title;
private String vol_no;
private String member_ID;
private String issue_Date;
private String due_Date;

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
  
  public String getVol_no() {
	return vol_no;
  }
  
  public void setVol_no(String vol_no) {
	this.vol_no = vol_no;
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
