package com.lms.beans;

import java.util.Date;

public class MagazineBean 
{
	private String referenceID;
	private String title;
	private int volumeNo;
	private int issueNO;
	private double cost;
	private String ISBN;
	private Date dateOfMagazine;
	private Date receiveDate;
	private String subscriptionType;
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
	public int getVolumeNo()
	{
		return volumeNo;
	}
	public void setVolumeNo(int volumeNo) 
	{
		this.volumeNo = volumeNo;
	}
	public int getIssueNO() 
	{
		return issueNO;
	}
	public void setIssueNO(int issueNO)
	{
		this.issueNO = issueNO;
	}
	public double getCost() 
	{
		return cost;
	}
	public void setCost(double cost) 
	{
		this.cost = cost;
	}
	public String getISBN()
	{
		return ISBN;
	}
	public void setISBN(String iSBN)
	{
		ISBN = iSBN;
	}
	public Date getDateOfMagazine()
	{
		return dateOfMagazine;
	}
	public void setDateOfMagazine(Date dateOfMagazine)
	{
		this.dateOfMagazine = dateOfMagazine;
	}
	public Date getReceiveDate() 
	{
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate)
	{
		this.receiveDate = receiveDate;
	}
	public String getSubscriptionType() 
	{
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType)
	{
		this.subscriptionType = subscriptionType;
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
	public String getReferenceID() 
	{
		return referenceID;
	}
	public void setReferenceID(String referenceID)
	{
		this.referenceID = referenceID;
	}
	
}