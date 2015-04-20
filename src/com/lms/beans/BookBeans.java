
  package com.lms.beans;
 

import java.util.Date;

public class BookBeans 
{
	private String referenceID;
	private String title;
	private String subject;
	private String edition;
	private String author;
	private String editor;
	private String publisher;
	private String pop;
	private int yop;
	private String ISBN;
	private double cost;
	private Date receiveDate;
	private int quantity;
	private String category;
	private String softDelete;
	public String getReferenceID()
	{
		return referenceID;
	}
	public void setReferenceID(String referenceID)
	{
		this.referenceID = referenceID;
	}
	public String getSoftDelete()
	{
		return softDelete;
	}
	public void setSoftDelete(String softDelete)
	{
		this.softDelete = softDelete;
	}
	public int getYop()
	{
		return yop;
	}
	public void setYop(int yop)
	{
		this.yop = yop;
	}
	public String getISBN()
	{
		return ISBN;
	}
	public void setISBN(String iSBN) 
	{
		ISBN = iSBN;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public Date getReceiveDate() 
	{
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate)
	{
		this.receiveDate = receiveDate;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category) 
	{
		this.category = category;
	}
	public void setPop(String pop)
	{
		this.pop = pop;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	public String getEdition() 
	{
		return edition;
	}
	public void setEdition(String edition)
	{
		this.edition = edition;
	}
	public String getAuthor() 
	{
		return author;
	}
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	public String getEditor()
	{
		return editor;
	}
	public void setEditor(String editor) 
	{
		this.editor = editor;
	}
	public String getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public String getPop() 
	{
		return pop;
	}
}