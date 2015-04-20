package com.lms.beans;

import java.util.Date;
public class Member
{
   String ref_id;
   String itemId;
   String title;
   String memberid;
   Date issueDate;
   Date dueDate;
   String status;
   double fine;
   String category;
  
   public String getRef_id() 
   {
		return ref_id;
   }
   public void setRef_id(String ref_id) 
   {
	    this.ref_id = ref_id;
   }
   public String getItemId() 
   {
	    return itemId;
   }
   public void setItemId(String itemId) 
   {
	   this.itemId = itemId;
   }
   public String getTitle() 
   {
	   return title;
   }
   public void setTitle(String title) 
   {
	  this.title = title;
   }
   public String getMemberId() 
   {
	 return memberid;
   }
   public void setMemberId(String memberid)
   {
	 this.memberid = memberid;
   }
   public Date getIssueDate() 
   {
	return issueDate;
   }
   public void setIssueDate(Date issueDate) 
   {
	this.issueDate = issueDate;
   }
   public Date getDueDate() 
   {
	return dueDate;
   }
   public void setDueDate(Date dueDate) 
   {
	this.dueDate = dueDate;
   }
   public String getStatus() 
   {
	return status;
   }
   public void setStatus(String status) 
   {
	this.status = status;
   }
   public double getFine() 
   {
	return fine;
   }
   public void setFine(double fine)
   {
	this.fine = fine;
   }
   public String getCategory() 
  {
	return category;
  }
  public void setCategory(String category) 
  {
	this.category = category;
  }
}
