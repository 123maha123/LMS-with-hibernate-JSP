package com.lms.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.beans.Book;
import com.lms.beans.CD;
import com.lms.beans.Magazine;
import com.lms.services.TransactionService;


/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hidden=request.getParameter("action");
		System.out.println(hidden);
		
		
		if("issueBook".equals(hidden))   // For issuing a book
		{
			Book book=new Book();
			book.setRefID(request.getParameter("id"));
			book.setTitle(request.getParameter("title"));
			book.setMember_ID(request.getParameter("memberId"));
			book.setIsbn_no(request.getParameter("isbn"));
			TransactionService ts=new TransactionService();
			int a = 0;
			try {
				a = ts.check(request.getParameter("memberId"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(a!=0)
			{
			try {
				ts.issueBook(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(a);
			RequestDispatcher rq=request.getRequestDispatcher("success.jsp");
			rq.forward(request, response);
			}
			else
			{
				RequestDispatcher rq=request.getRequestDispatcher("failure.jsp");
				rq.forward(request, response);
			}
		}
		
		
		else if("issueCD".equals(hidden))   // For issuing a CD
		{
			CD cd=new CD();
			cd.setRefID(request.getParameter("id"));
			cd.setTitle(request.getParameter("title"));
			cd.setMember_ID(request.getParameter("memberId"));

			
			
			
			
			TransactionService ts=new TransactionService();
			int a=0;
			try {
				a = ts.check(request.getParameter("memberId"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(a!=0)
			{
			try {
				ts.issueCD(cd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hai");
			RequestDispatcher rq=request.getRequestDispatcher("success.jsp");
			rq.forward(request, response);
			}
			else
			{
				RequestDispatcher rq=request.getRequestDispatcher("failure.jsp");
				rq.forward(request, response);
			}
			
		}
		
		else if("issueMagazine".equals(hidden))   // For issuing a magazine
		{
			Magazine magazine = new Magazine();
			magazine.setRefID(request.getParameter("id"));
			magazine.setTitle(request.getParameter("title"));
			magazine.setMember_ID(request.getParameter("memberId"));
            magazine.setVol_no(request.getParameter("volno"));
			
			
			
			try{
			TransactionService ts=new TransactionService();
			int a=ts.check(request.getParameter("memberId"));
			if(a!=0)
			{
			ts.issueMagazine(magazine);
			System.out.println("hai");
			RequestDispatcher rq=request.getRequestDispatcher("success.jsp");
			rq.forward(request, response);
			}
			else
			{
				RequestDispatcher rq=request.getRequestDispatcher("failure.jsp");
				rq.forward(request, response);
			
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
		
		else if("return".equals(hidden)) // For returning a book/CD/Magazine
		{
			
			String searchmemberId= request.getParameter("mid");
			
			TransactionService transactionService= new TransactionService();
			
			ArrayList<Book> bookList = null;
			
			try {
				bookList = transactionService.returnBooks(searchmemberId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			request.setAttribute("bookList", bookList);
			RequestDispatcher rd= request.getRequestDispatcher("returnList.jsp");
			rd.forward(request, response);
		
		
		
		}
    
		
		else if ("returnf".equals(hidden)) // For displaying the list to return the book/CD/Magazine
		{
			
			String refId = request.getParameter("refid");
			TransactionService transactionService= new TransactionService();
			try {
				transactionService.returnStatus(refId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}
		
		
		else if("renewal".equals(hidden)) // For renewing a book/CD/Magazine
			{
				
				String searchmemberId= request.getParameter("mid");
				
				TransactionService transactionService= new TransactionService();
				
				ArrayList<Book> bookList = null;
				
				try {
					bookList = transactionService.renewBooks(searchmemberId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				request.setAttribute("bookList", bookList);
				RequestDispatcher rd= request.getRequestDispatcher("renewList.jsp");
				rd.forward(request, response);
			
			
			
			}
		
		
		else if ("renewalf".equals(hidden))  // For displaying the list to renew the book/CD/Magazine
		{
			
			String refId = request.getParameter("refID");
			TransactionService transactionService= new TransactionService();
			try {
				System.out.println("kk");
				transactionService.renewStatus(refId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			}
		else
		{
			
			String name=request.getParameter("drop");
			String title=request.getParameter("title");
			String isbn=request.getParameter("isbn");
			String volume=request.getParameter("volume");
			
		    TransactionService ts=new TransactionService();
			String last=null;
			
			if(name.equals("book")) //to display the book
			{
				last=isbn;
				
				ArrayList<Book> list=null;
				try {
					list = ts.displayBook(name, isbn,title);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.setAttribute("userList", list);
				System.out.println(list.size());
				
				RequestDispatcher rq=request.getRequestDispatcher("result.jsp");
				rq.forward(request, response);
			}
			
			if(name.equals("cd")) //to display the CD
			{
				last=title;
				ArrayList<CD> list=null;
				try {
					list = ts.displayCD(name, isbn,title);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("userList", list);
				System.out.println(list.size());
				
				RequestDispatcher rq=request.getRequestDispatcher("result1.jsp");
				rq.forward(request, response);
			}
			
			if(name.equals("magazine")) //to display the magazine
			{
				last=volume;
				ArrayList<Magazine> list=null;
				try {
					list = ts.displayMagazine(name, isbn,title);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.setAttribute("userList", list);
				System.out.println(list.size());
				
				RequestDispatcher rq=request.getRequestDispatcher("result2.jsp");
				rq.forward(request, response);
			}
			
			
		
		}
	}

}
