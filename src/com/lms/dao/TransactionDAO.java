package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.beans.Book;
import com.lms.beans.CD;
import com.lms.beans.Magazine;
import com.lms.util.DBConnection;


public class TransactionDAO {
private Connection conn=null;
	
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement pre= null;
	public int fi;
	
	
	public ArrayList<Book> returnBooks(String member_ID) // to return the book/CD/Magazine
	{
		ArrayList<Book> bookList= new ArrayList<Book>();
		
		try{
		Connection con= DBConnection.getConnection();
		System.out.println("hello");
		String query= "select * from statusreportt where memberID = ? and status != 'R' and status != 'RP' and duedate>=sysdate ";
		System.out.println("helloo");
	    pre = con.prepareStatement(query);
	    pre.setString(1, member_ID);
	    rs= pre.executeQuery();
	
	while(rs.next())
	{
		System.out.println("helloo");
		String id= rs.getString("RefId");
		String isbn = rs.getString("ISBN_cdno_volno");
		String memberID= rs.getString("MemberID");
		String issue_dat= rs.getString("IssueDate");
		String issue_date=issue_dat.substring(0,10);
		String due_dat= rs.getString("DueDate");
		String due_date=due_dat.substring(0, 10);;
		String category = rs.getString("category");
		String status = rs.getString("status");
        System.out.println(memberID);
		Book  book= new Book();
        book.setRefID(id);
		book.setIsbn_no(isbn);
	    book.setMember_ID(memberID);
		book.setIssue_Date(issue_date);
		book.setDue_Date(due_date);
		book.setCategory(category);
		book.setStatus(status);
		bookList.add(book);
	}		
	}
		catch(Exception e)                   
	    {
		   e.printStackTrace();
	    }
		 return bookList;
	}
	
	
	public void returnStatus(String refId) // to update the return status
	{
		
		try
		{
			
		Connection con= DBConnection.getConnection();
		String query =" update statusreportt set status='R' where refid=? ";
		String query1 ="update tbl_book set status='R' where referenceid=?";
		pre = con.prepareStatement(query);
		pre.setString(1, refId);
		int rs= pre.executeUpdate();
		pre = con.prepareStatement(query1);
		pre.setString(1, refId);
		int rs1= pre.executeUpdate();
		
		}catch(Exception e)                   
		{
			e.printStackTrace();
		}	
	}
	
	
	
	public ArrayList<Book> renewBooks(String member_ID) //to renew the book/CD/Magazine
	{
		ArrayList<Book> bookList= new ArrayList<Book>();
		
		try{
		Connection con= DBConnection.getConnection();
		System.out.println("hello");
		String query= "select * from statusreportt where memberID = ? and status!='R' and status != 'RP' ";
		System.out.println("helloo");
	pre = con.prepareStatement(query);
	pre.setString(1, member_ID);
	rs= pre.executeQuery();
	
	while(rs.next())
	{
		System.out.println("helloo");
		String id= rs.getString("RefId");
		 String isbn = rs.getString("ISBN_cdno_volno");
		String memberID= rs.getString("MemberID");
		String issue_dat= rs.getString("IssueDate");
		String issue_date=issue_dat.substring(0,10);
		String due_dat= rs.getString("DueDate");
		String due_date=due_dat.substring(0, 10);
		String category = rs.getString("category");
		String status = rs.getString("status");
        System.out.println(memberID);
		Book  book= new Book();
        book.setRefID(id);
		book.setIsbn_no(isbn);
	     book.setMember_ID(memberID);
		book.setIssue_Date(issue_date);
		book.setDue_Date(due_date);
		book.setCategory(category);
		book.setStatus(status);
		bookList.add(book);
	}
	
		}
		catch(Exception e)                   
		{
			e.printStackTrace();
		}
         return bookList;
      
	}
	
	
	
	public void renewStatus(String refId) throws SQLException // to update the renew status
	{
		
	System.out.println("aaaaaa"+ refId);
		
	try
	{
		
	System.out.println(refId);
	Connection con= DBConnection.getConnection();
	String query ="update statusreportt set status='RN',issuedate=(to_date(sysdate)),duedate=(to_date(sysdate)+15) where refid= ? and status='I'";
	String query1 ="update tbl_book set status='RN' where referenceid=?";
	pre = con.prepareStatement(query);
	pre.setString(1, refId);
	int rs= pre.executeUpdate();
	pre = con.prepareStatement(query1);
	pre.setString(1, refId);
	int rs1= pre.executeUpdate();
	}
	catch(Exception e)                   
	{
		e.printStackTrace();
	}
	}
	
	
	
	public int check(String id)
	{
		int res=0;
		
		try
		{
		
			System.out.println("hi");
			conn=DBConnection.getConnection();
		
			st=conn.createStatement();
			
		
			String query ="select *from userE where memberid='"+id+"'";
			rs= st.executeQuery(query);
			while(rs.next())
			{
				res++;
			}
			
		   System.out.println("number os recor"+res);
			
		}
		catch(Exception e)                   
		{
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	
	
	public void issueBook(Book b) //for issuing the book
	{
		try
		{
		
			System.out.println("hi");
			conn=DBConnection.getConnection();
		
			st=conn.createStatement();
			
			String query = "insert into statusreportt values('"+b.getRefID()+"','"+b.getIsbn_no()+"','"+b.getMember_ID()+"',"
					         +"(to_date(sysdate,('DD-MM-YY HH24:MI:SS'))),"
					         +"(to_date(sysdate,('DD-MM-YY HH24:MI:SS'))+15),'I','Book',0)";
			
			String query1 ="update tbl_book set status='I' where referenceid='"+b.getRefID()+"'";
			int custID= st.executeUpdate(query);
			int custID1= st.executeUpdate(query1);
		    System.out.println(b.getRefID());
			
		}catch(Exception e)                   
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void issueCD(CD cd)  //for issuing the CD
	{
		try
		{
//			
			System.out.println("hi");
			conn=DBConnection.getConnection();
		
			st=conn.createStatement();
		
			String query = "insert into statusreportt values('"+cd.getRefID()+"','"+cd.getTitle()+"','"+cd.getMember_ID()+"',(to_date(sysdate,('DD-MM-YY HH24:MI:SS'))),(to_date(sysdate,('DD-MM-YY HH24:MI:SS'))+15),'I','CD',0)";
			String query1 ="update tbl_cd set status='I' where referenceid='"+cd.getRefID()+"'";
			int custID1= st.executeUpdate(query1);
			int custID= st.executeUpdate(query);
		    System.out.println(custID);
			
		}catch(Exception e)                   
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void issueMagazine(Magazine magazine)   //for issuing the magazine
	{
		try
		{
//			
			System.out.println("hi");
			conn=DBConnection.getConnection();
		
			st=conn.createStatement();
		
			String query = "insert into statusreportt values('"+magazine.getRefID()+"','"+magazine.getVol_no()+"','"+magazine.getMember_ID()+"',(to_date(sysdate,('DD-MM-YY HH24:MI:SS'))),(to_date(sysdate,('DD-MM-YY HH24:MI:SS'))+15),'I','Magazine',0)";
			String query1 ="update tbl_magazine set status='I' where referenceid='"+magazine.getRefID()+"'";
			int custID= st.executeUpdate(query);
			int custID1= st.executeUpdate(query1);
		    System.out.println(custID);
			
		}catch(Exception e)                   
		{
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Book> displayBook(String name,String isbn,String title) //For displaying the books
	{
		ArrayList<Book> list=new ArrayList<Book>();
		try
		{
		conn=DBConnection.getConnection();
		
		st=conn.createStatement();
		if(!isbn.equals(""))
		{
		String query ="select * from tbl_book where ISBN='"+isbn+"' and (status='R' or status='RP') and softdelete='no'";
		rs=st.executeQuery(query);
		}
		else if(!title.equals(""))
		{
			String query ="select * from tbl_book where Title='"+title+"' and (status='R' or status='RP') and softdelete='no'";
			rs=st.executeQuery(query);
			
		}
		
		while(rs.next())
		{
			 Book b=new Book();
			 b.setRefID((rs.getString(1)));
			 b.setTitle((rs.getString(3)));
			 b.setIsbn_no((rs.getString(2)));
			 list.add(b);
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public ArrayList<CD> displayCD(String name,String isbn,String title) //For displaying the CD
	{
		ArrayList<CD> list=new ArrayList<CD>();
		try
		{
		conn=DBConnection.getConnection();
		
		st=conn.createStatement();
		 if(!title.equals(""))
		{
			String query ="select * from tbl_cd where Title='"+title+"' and (status='R' or status='RP') and softdelete='no'";
			rs=st.executeQuery(query);
			
		}
		
		while(rs.next())
		{
			CD b=new CD();
			 b.setRefID((rs.getString(1)));
			 b.setTitle((rs.getString(2)));
			 list.add(b);
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	 
	public ArrayList<Magazine> displayMagazine( String name,String isbn,String title) //For displaying the magazine
	{
		ArrayList<Magazine> list=new ArrayList<Magazine>();
		try
		{
		conn=DBConnection.getConnection();
		
		st=conn.createStatement();
		 if(!title.equals(""))
		{
			String query ="select * from tbl_magazine where Title='"+title+"' and (status='R'  or status='RP') and softdelete='no'";
			rs=st.executeQuery(query);
			
		}
		 
		while(rs.next())
		{
			 Magazine b=new Magazine();
			 b.setRefID((rs.getString(1)));
			 b.setVol_no(rs.getString(2));
			 b.setTitle((rs.getString(3)));
			 list.add(b);
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
}
