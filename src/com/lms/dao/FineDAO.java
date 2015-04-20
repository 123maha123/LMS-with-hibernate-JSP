package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.lms.beans.Member;
import com.lms.util.DBConnection;
/**
 *   The FineDAO Class provides functions that access the data in the database
 */
public class FineDAO 
{
	    ResultSet rs= null;
	    PreparedStatement pre= null;
	    Connection con=null;
	     /**
	      *   The defaultersList Function provides the list of defaulters who had not paid the fine 
	      */ 
		public ArrayList<Member> defaultersList(Date fromdate,Date todate) throws SQLException  
		{
		    con= DBConnection.getConnection();
		    System.out.println("in dao:");
		    ArrayList<Member> dlist= new ArrayList<Member>();
		    System.out.println("wish");
			String query= "select * from statusreportt where issuedate between ? and ? and  status='I'";
			try
			 {
			   System.out.println("in dao:");
		       pre = con.prepareStatement(query);
		       pre.setDate(1,new java.sql.Date(fromdate.getTime()));
		       pre.setDate(2,new java.sql.Date(todate.getTime()));
               rs = pre.executeQuery();
               while(rs.next())
		      { 
		    	System.out.println("helloo");
			    double fine=0.0,x=0.0;
			    double  day=0;
				Date myDate = new Date();
				System.out.println(myDate);
				SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
				String f=fm.format(myDate);
				System.out.println("My date:"+f);
				Date t=fm.parse(f);
				System.out.println("My date:"+t);
				Date duedate=rs.getDate("DueDate");
				long d = (fm.parse(f)).getTime()- duedate.getTime();
				System.out.println("d value:"+d);
				day=(double)d / 1000L / 60L / 60L / 24L;
				System.out.println("Days:"+day);
				if(day>1)
				{   
					  x= (day/15)*100;
					 fine=50+((day-1)*10)+x;
					 System.out.println("total fine is"+fine);
				}
				   
				double rf = (double) Math.round(fine * 100) / 100;
				System.out.println(fine +" rounded is "+ rf);
				String q="update statusreportt set fine="+rf+"where status='I'";
				pre=con.prepareStatement(q);
				pre.executeQuery();
				System.out.println("in dao:");
				String ref_id=rs.getString("RefId");
				String MemberId= rs.getString("memberID");
				String itemid=rs.getString("ISBN_cdno_volno");
				String Category= rs.getString("category");
				Date DueDate=rs.getDate("DueDate");
				String Status=rs.getString("STATUS");
				System.out.println("in dao:");
				Member m= new Member();
				m.setMemberId(MemberId);
				m.setRef_id(ref_id);
				m.setItemId(itemid);
				m.setCategory(Category);
				m.setDueDate(DueDate);
	            m.setFine(rf) ;  
	            m.setStatus(Status);
				dlist.add(m);
				  
			   }
		    }   
		    catch(SQLException e) 
		    {
		      e.printStackTrace();	
		    } catch (ParseException e) 
		    {
			  e.printStackTrace();
			}
			
		return dlist;
		
		}

/**
 *   The searchList Function provides the  details of the particular member
 */

		public ArrayList<Member> searchList(String memberid,String category,Date fromdate,Date todate) throws SQLException  
		{
		    con= DBConnection.getConnection();
		    System.out.println("in dao:"+memberid+":"+category);
		    ArrayList<Member> mlist= new ArrayList<Member>();
		    System.out.println("wish");
			String query= "select * from statusreportt where  MEMBERID=? and STATUS='I' and category=? and issuedate between ? and ?";
			 //where memberID=? and  category=? and status='I'		      
			 try
			 {
			     System.out.println("in dao:"+memberid+":"+category);
			     pre = con.prepareStatement(query);
		         pre.setString(1,memberid);
		         pre.setString(2,category);
		         pre.setDate(3,new java.sql.Date(fromdate.getTime()));
		         pre.setDate(4,new java.sql.Date(todate.getTime()));
		        // pst.setDate(13, new java.sql.Date(b.getReceiveDate().getTime()));
		         rs = pre.executeQuery();
                System.out.println("in dao:"+memberid+":"+category+new java.sql.Date(fromdate.getTime())+new java.sql.Date(todate.getTime()));
		        while(rs.next())
		        { 
		    	 System.out.println("helloo");
			     double fine=0.0,x=0.0;
			     double  day=0;
				 Date myDate = new Date();
				 System.out.println(myDate);
				 SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
				 String f=fm.format(myDate);
				 System.out.println("My date:"+f);
				 Date t=fm.parse(f);
				 System.out.println("My date:"+t);
			     Date duedate=rs.getDate("DueDate");
				 long d =  (fm.parse(f)).getTime()-duedate.getTime();
				 System.out.println("d value:"+d);
				 day=(double)d / 1000L / 60L / 60L / 24L;
				 System.out.println("Days:"+day);
				 if(day>1)
				     {   
					   x= (day/15)*100;
					   fine=50+((day-1)*10)+x;
					   System.out.println("total fine is"+fine);
				     }
				   double rf = (double) Math.round(fine * 100) / 100;
				   System.out.println(fine +" rounded is "+ rf);
				   String q="update statusreportt set fine="+rf+"where status='I'"; 
				   pre=con.prepareStatement(q);
				   pre.executeQuery();
				   System.out.println("in dao:");
				   String ref_id=rs.getString("RefId");
				   String MemberId= rs.getString("MEMBERID");
				   String itemid=rs.getString("ISBN_cdno_volno");
				   String Category= rs.getString("category");
				   Date DueDate=rs.getDate("DueDate");
				   String Status=rs.getString("STATUS");
				   System.out.println("in dao:"+memberid+":"+category);
				   Member m= new Member();
				   m.setMemberId(MemberId);
				   m.setRef_id(ref_id);
				   m.setItemId(itemid);
				   m.setCategory(Category);
				   m.setDueDate(DueDate);
				   m.setStatus(Status);
	               m.setFine(rf) ;  
				   mlist.add(m);
				  
			    }
			 }   
		    catch(SQLException e) 
		    {
		      e.printStackTrace();	
		    } catch (ParseException e) 
		    {
			  e.printStackTrace();
			}
			
			 return mlist;
		 }
		/**
		 *   The payment Function  update status of member who had paid fine
		 */	
			
		
		public void payment(String refid) throws SQLException
		{
			 con= DBConnection.getConnection();
			 String query="update statusreportt set STATUS='RP',FINE=0 where REFID=? and status='I'";
			 try
			 {
				 pre = con.prepareStatement(query);
				 pre.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
			 PreparedStatement pre1=null;
			 query="update tbl_book set STATUS='RP'where ReferenceID=?";
			 try
			 {
				 pre1 = con.prepareStatement(query);
				 pre1.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre1.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
			 PreparedStatement pre2=null;
			 query="update tbl_magazine set STATUS='RP'where ReferenceID=?";
			 try
			 {
				 pre2 = con.prepareStatement(query);
				 pre2.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre2.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
			 PreparedStatement pre3=null;
			 query="update tbl_cd set STATUS='RP'where ReferenceID=?";
			 try
			 {
				 pre3 = con.prepareStatement(query);
				 pre3.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre3.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
		}
		
/**
 *   The cancel Function update status of member whose fine is cancelled
 */
		public void cancel(String refid) throws SQLException
		{

			 con= DBConnection.getConnection();
			 String query="update statusreportt set status='R',fine=0 where REFID=?";
			 try
			 {
				 System.out.println("in dao refid"+refid);
				 pre = con.prepareStatement(query);
				 pre.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre.executeQuery();
		     }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
             PreparedStatement pre1=null;
			 query="update tbl_book set STATUS='RP'where ReferenceID=?";
			 try
			 {
				 pre1 = con.prepareStatement(query);
				 pre1.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre1.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
			 PreparedStatement pre2=null;
			 query="update tbl_magazine set STATUS='RP'where ReferenceID=?";
			 try
			 {
				 pre2 = con.prepareStatement(query);
				 pre2.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre2.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
			 PreparedStatement pre3=null;
			 query="update tbl_cd set STATUS='RP'where ReferenceID=?";
			 try
			 {
				 pre3 = con.prepareStatement(query);
				 pre3.setString(1,refid);
				 System.out.println("in dao refid"+refid);
			     pre3.executeUpdate();
			 }
		     catch(SQLException e) 
			    {
			      e.printStackTrace();	
			    }
		   }
		}

