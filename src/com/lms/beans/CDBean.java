package com.lms.beans;

import java.util.Date;

public class CDBean 
{
	private String referenceID;
	private String title;
	private String subject;
	private String publisher;
	private String pop;
	private int yop;
	private double cost;
	private Date receivedDate;
	private int quantity;
	private String softDelete;
	
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

	public void setPop(String pop)
	{
		this.pop = pop;
	}

	public int getYop()
	{
		return yop;
	}

	public void setYop(int yop)
	{
		this.yop = yop;
	}

	public double getCost() 
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getSoftDelete()
	{
		return softDelete;
	}

	public void setSoftDelete(String softDelete)
	{
		this.softDelete = softDelete;
	}

	public Date getReceivedDate() 
	{
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate)
	{
		this.receivedDate = receivedDate;
	}

	public String getReferenceID()
	{
		return referenceID;
	}

	public void setReferenceID(String referenceID)
	{
		this.referenceID = referenceID;
	}

}
