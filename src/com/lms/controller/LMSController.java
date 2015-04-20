package com.lms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.beans.BookBeans;
import com.lms.beans.CDBean;
import com.lms.beans.MagazineBean;
import com.lms.services.LMSServices;

/**
 * Servlet implementation class LMSController
 */
@WebServlet("/LMSController")
public class LMSController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LMSController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String action=request.getParameter("action");
			if("addBook".equals(action))// add book
			{
				System.out.println("add book");
				BookBeans book=new BookBeans();
				book.setISBN(request.getParameter("isbn"));
				book.setTitle(request.getParameter("title"));
				book.setSubject(request.getParameter("subject"));
				book.setCategory(request.getParameter("category"));
				book.setEdition(request.getParameter("edition"));
				book.setAuthor(request.getParameter("author"));
				book.setEditor(request.getParameter("editor"));
				book.setPublisher(request.getParameter("publisher"));
				book.setPop(request.getParameter("placeOfPublication"));
				int yop=Integer.parseInt(request.getParameter("yearOfPublication"));
				book.setYop(yop);
				book.setCost(Double.parseDouble(request.getParameter("cost")));
				book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				
				String d=request.getParameter("receivedDate");
				Date date;
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date =df.parse(d);
					book.setReceiveDate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				LMSServices services=new LMSServices();
				String referenceID= services.addBook(book);
				request.setAttribute("referenceID",referenceID);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("BookResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			else if("addMagazine".equals(action))// add magazine
			{
				MagazineBean m=new MagazineBean();
				m.setTitle(request.getParameter("title"));
				m.setVolumeNo(Integer.parseInt(request.getParameter("volumeNo")));
				m.setIssueNO(Integer.parseInt(request.getParameter("issueNo")));
				m.setISBN(request.getParameter("isbn"));
				m.setCost(Double.parseDouble(request.getParameter("cost")));
				String d=request.getParameter("dateOfMagazine");
				Date date;			
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				date =df.parse(d);
				m.setDateOfMagazine(date);
				d=request.getParameter("receivedDate");
				df=new SimpleDateFormat("MM/dd/yyyy");
				date=df.parse(d);
				m.setReceiveDate(date);
				m.setSubscriptionType(request.getParameter("subscription"));
				m.setQuantity(Integer.parseInt(request.getParameter("quantity")));

				LMSServices services=new LMSServices();
				String referenceID= services.addMagazine(m);
				request.setAttribute("referenceID",referenceID);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("MagazineResultPage.jsp");
				reqdispatcher.forward(request, response);		
			}
			else if("addCD".equals(action))//add cd
			{
				CDBean cd=new CDBean();
				cd.setTitle(request.getParameter("title"));
				cd.setSubject(request.getParameter("subject"));
				cd.setPublisher(request.getParameter("publisher"));
				cd.setPop(request.getParameter("placeOfPublication"));
				int yop=Integer.parseInt(request.getParameter("yearOfPublication"));
				cd.setYop(yop);
				cd.setCost(Double.parseDouble(request.getParameter("cost")));
				cd.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				
				String d=request.getParameter("receivedDate");
				Date date;
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date =df.parse(d);
					cd.setReceivedDate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				LMSServices services=new LMSServices();
				String referenceID= services.addCD(cd);
				request.setAttribute("referenceID",referenceID);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("CDResultPage.jsp");
				reqdispatcher.forward(request, response);	
				
			}
			else if("login".equals(action))//login
			{
				LMSServices services=new LMSServices();
				boolean validUser=services.validateUser(request.getParameter("userID"),request.getParameter("password"));
				if(validUser)
				{
					RequestDispatcher reqdispatcher=request.getRequestDispatcher("MenuPage.jsp");
					reqdispatcher.forward(request, response);
				}
				else
				{
					RequestDispatcher reqdispatcher=request.getRequestDispatcher("Home.jsp");
					reqdispatcher.forward(request, response);
				}
			}
			else if("deleteBookById".equals(action))//delete book
			{
				LMSServices services=new LMSServices();
				boolean deleteFlag=services.deleteBook(request.getParameter("refID"));
				request.setAttribute("deleteFlag", deleteFlag);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("BookDeleteResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			else if("deleteMagazineById".equals(action))// delete magazine
			{
				LMSServices services=new LMSServices();
				boolean deleteFlag=services.deleteMagazine(request.getParameter("refID"));
				request.setAttribute("deleteFlag", deleteFlag);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("MagazineDeleteResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			else if("deleteCDById".equals(action))// delete cd
			{
				LMSServices services=new LMSServices();
				boolean deleteFlag=services.deleteCD(request.getParameter("refID"));
				request.setAttribute("deleteFlag", deleteFlag);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("CDDeleteResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			else if("searchBookById".equals(action))//search book
			{
				LMSServices services=new LMSServices();
				String refID=request.getParameter("refID");
				ArrayList<BookBeans> bookList=services.searchBookByID(refID);
				request.setAttribute("bookList", bookList);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("UpdateBook.jsp");
				reqdispatcher.forward(request, response);
			}
			else if("viewBookById".equals(action))//view book details
			{
				LMSServices services=new LMSServices();
				String refID=request.getParameter("refID");
				ArrayList<BookBeans> bookList=services.searchBookByID(refID);
				request.setAttribute("bookList", bookList);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("ViewBookDetails.jsp");
				reqdispatcher.forward(request, response);
			}
			else if("updateBook".equals(action))//update book
			{
				BookBeans book=new BookBeans();
				book.setReferenceID(request.getParameter("refID"));
				book.setISBN(request.getParameter("isbn"));
				book.setTitle(request.getParameter("title"));
				book.setSubject(request.getParameter("subject"));
				book.setCategory(request.getParameter("category"));
				book.setEdition(request.getParameter("edition"));
				book.setAuthor(request.getParameter("author"));
				book.setEditor(request.getParameter("editor"));
				book.setPublisher(request.getParameter("publisher"));
				book.setPop(request.getParameter("placeOfPublication"));
				int yop=Integer.parseInt(request.getParameter("yearOfPublication"));
				book.setYop(yop);
				book.setCost(Double.parseDouble(request.getParameter("cost")));
				book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				
				String d=request.getParameter("receivedDate");
				Date date;
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date =df.parse(d);
					book.setReceiveDate(date);
					System.out.println(date);
				} 
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				book.setSoftDelete(request.getParameter("softDelete"));
				LMSServices services=new LMSServices();
				String referenceID= services.updateBook(book);
				request.setAttribute("referenceID",referenceID);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("BookUpdateResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			
			else if("searchCDById".equals(action))//search cd
			{
				LMSServices services=new LMSServices();
				String refID=request.getParameter("refID");
				ArrayList<CDBean> CDList=services.searchCDByID(refID);
				request.setAttribute("CDList", CDList);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("UpdateCD.jsp");
				reqdispatcher.forward(request, response);
			}
			
			else if("viewCDById".equals(action))//view cd details
			{
				LMSServices services=new LMSServices();
				String refID=request.getParameter("refID");
				ArrayList<CDBean> CDList=services.searchCDByID(refID);
				request.setAttribute("CDList", CDList);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("ViewCDDetails.jsp");
				reqdispatcher.forward(request, response);
			}
			
			else if("updateCD".equals(action))//update cd
			{
				CDBean cd=new CDBean();
				cd.setReferenceID(request.getParameter("refID"));
				cd.setTitle(request.getParameter("title"));
				cd.setSubject(request.getParameter("subject"));
				cd.setPublisher(request.getParameter("publisher"));
				cd.setPop(request.getParameter("placeOfPublication"));
				int yop=Integer.parseInt(request.getParameter("yearOfPublication"));
				cd.setYop(yop);
				cd.setCost(Double.parseDouble(request.getParameter("cost")));
				cd.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				String d=request.getParameter("receivedDate");
				Date date;
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date =df.parse(d);
					cd.setReceivedDate(date);
					System.out.println(date);
				} 
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				cd.setSoftDelete(request.getParameter("softDelete"));
				LMSServices services=new LMSServices();
				String referenceID= services.updateCD(cd);
				request.setAttribute("referenceID",referenceID);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("CDUpdateResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			
			else if("searchMagazineById".equals(action))//search magazine
			{
				LMSServices services=new LMSServices();
				String refID=request.getParameter("refID");
				ArrayList<MagazineBean> magazineList=services.searchMagazineByID(refID);
				request.setAttribute("magazineList", magazineList);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("UpdateMagazine.jsp");
				reqdispatcher.forward(request, response);
			}
			else if("viewMagazineById".equals(action))//view magazine details
			{
				LMSServices services=new LMSServices();
				String refID=request.getParameter("refID");
				ArrayList<MagazineBean> magazineList=services.searchMagazineByID(refID);
				request.setAttribute("magazineList", magazineList);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("ViewMagazineDetails.jsp");
				reqdispatcher.forward(request, response);
			}
			else if("updateMagazine".equals(action))//update magazine
			{
				MagazineBean magazine=new MagazineBean();
				magazine.setReferenceID(request.getParameter("refID"));
				magazine.setISBN(request.getParameter("isbn"));
				magazine.setTitle(request.getParameter("title"));
				magazine.setVolumeNo(Integer.parseInt(request.getParameter("volumeNo")));
				magazine.setIssueNO(Integer.parseInt(request.getParameter("issueNo")));
				magazine.setCost(Double.parseDouble(request.getParameter("cost")));
				
				String d=request.getParameter("dateOfMagazine");
				Date date;
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date =df.parse(d);
					magazine.setDateOfMagazine(date);
				} 
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				
				d=request.getParameter("receivedDate");
				df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date =df.parse(d);
					magazine.setReceiveDate(date);
				} 
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				magazine.setSubscriptionType(request.getParameter("subscription"));
				magazine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				magazine.setSoftDelete(request.getParameter("softDelete"));
				LMSServices services=new LMSServices();
				String referenceID= services.updateMagazine(magazine);
				request.setAttribute("referenceID",referenceID);
				RequestDispatcher reqdispatcher=request.getRequestDispatcher("MagazineUpdateResultPage.jsp");
				reqdispatcher.forward(request, response);	
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
