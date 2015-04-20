package com.lms.services;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.lms.beans.Member;
import com.lms.dao.FineDAO;

public class FineService 
{
    FineDAO dao= new FineDAO();

/**
 *   The searchList Function provides the  details of the particular member
 */
	public ArrayList<Member>searchList(String memberid,String category,Date fromdate,Date todate) throws SQLException 
	{
		 System.out.println("in service:"+memberid+":"+category);
	     ArrayList<Member> list=  dao.searchList(memberid,category,fromdate,todate);
	     return list;
	}
/**
 *   The defaultersList Function provides the list of defaulters who had not paid the fine 
 */ 
	public ArrayList<Member> defaultersList(Date fromdate,Date todate) throws SQLException 
	{
		 System.out.println("in service:");
	     ArrayList<Member> list=  dao.defaultersList( fromdate, todate);
	     return list;
	}
/**
  *   The payment Function  update status of member who had paid fine
   */
	public void payment(String refid) throws SQLException
	{
	   dao.payment(refid);	
	}
	
/**
  *  The cancel Function update status of member whose fine is cancelled
  */
	public void cancel(String refid ) throws SQLException
	{
		dao.cancel(refid);
	}
}
