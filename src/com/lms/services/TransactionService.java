package com.lms.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lms.beans.Book;
import com.lms.beans.CD;
import com.lms.beans.Magazine;
import com.lms.dao.TransactionDAO;


public class TransactionService {
	
	public int check(String id)throws Exception
	{
		TransactionDAO transactionDAO= new TransactionDAO();
		int id1 = transactionDAO.check(id);
		return id1;
	}
	
	public ArrayList<Book> returnBooks(String member_ID) throws Exception  //to return the book/CD/Magazine
	{    
		
		TransactionDAO transactionDAO= new TransactionDAO();
		ArrayList<Book> bookList = transactionDAO.returnBooks(member_ID);
		System.out.println(bookList);
		return bookList;
	}
	
	public void returnStatus(String refId) throws Exception //to update the return status
	{
		
		TransactionDAO transactionDAO= new TransactionDAO();
		transactionDAO.returnStatus(refId);
	}
	
	public ArrayList<Book> renewBooks(String member_ID) throws Exception  //to renew the book/CD/Magazine
	{    
		
		TransactionDAO transactionDAO= new TransactionDAO();
		ArrayList<Book> bookList = transactionDAO.renewBooks(member_ID);
		return bookList;
	}
	
	public void renewStatus(String refId)throws Exception  //to update the renew status along with the issue and due dates
	{
		
		TransactionDAO transactionDAO= new TransactionDAO();
		try {
			transactionDAO.renewStatus(refId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void issueBook(Book book)throws Exception // for issuing a book
    {
	     TransactionDAO td=new TransactionDAO();
	     td.issueBook(book);
     }
    
   public void issueCD(CD cd)throws Exception // for issuing a CD
     {
	    TransactionDAO td=new TransactionDAO();
	    td.issueCD(cd);
     }
   
   public void issueMagazine(Magazine magazine)throws Exception  // for issuing a Magazine
    {
	    TransactionDAO td=new TransactionDAO();
	    td.issueMagazine(magazine);
    }
   
   public ArrayList<Book> displayBook(String name,String isbn,String title)throws Exception //To display the books 
    {
	    TransactionDAO td=new TransactionDAO();
	    ArrayList<Book> list=td.displayBook(name,isbn,title);
	    System.out.println("in service");
        return list;
    }
   
   public ArrayList<CD> displayCD(String name,String isbn,String title)throws Exception //To display the CD
    {
	   TransactionDAO td=new TransactionDAO();
	   ArrayList<CD> list=td.displayCD(name,isbn,title);
	   System.out.println("in service");
	   return list;
	}

   public ArrayList<Magazine> displayMagazine( String name,String isbn,String title)throws Exception  //To display the magazine
   {
	  TransactionDAO td=new TransactionDAO();
	  ArrayList<Magazine> list=td.displayMagazine(name,isbn,title);
	  System.out.println("in service");
      return list;
   }
   
}
