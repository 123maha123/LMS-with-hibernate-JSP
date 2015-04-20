package com.lms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import com.lms.beans.Member;
import com.lms.services.FineService;
@WebServlet("/FineController")
public class FineController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	FineService service=new FineService();	
    RequestDispatcher rd,rd1;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String  memberid = request.getParameter("memberid");
        String  category = request.getParameter("category");
        String  action=request.getParameter("action");
        System.out.println("in controller:"+action);
        try
        {
        // Provides the  details of the particular member
         if("memberdetails".equals(action))
          {	
             System.out.println("in controller:"+memberid+":"+category);
             String d1=request.getParameter("fromdate");
     	     DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		     Date fromdate =df.parse(d1);
		     String d2=request.getParameter("todate");
	         Date todate =df.parse(d2);
		     System.out.println("fromdate"+fromdate);
		     System.out.println("todate"+todate);
             ArrayList<Member> mlist = service.searchList(memberid, category,fromdate,todate);
		     System.out.println("in controller:"+memberid+":"+category);
             request.setAttribute("mlist", mlist);
             if(mlist!=null)
             {	
	              rd= request.getRequestDispatcher("/viewDetails.jsp");
	              rd.forward(request, response);
             }
             if(mlist==null)
             {
        	     rd1= request.getRequestDispatcher("/NotFound.jsp");
     	         rd1.forward(request, response);	
             }
         }
         // Provides the list of defaulters 
         else if("defaulters".equals(action))
        {
        	System.out.println("in controller:");
            Member m=new Member();
            String d1=request.getParameter("fromdate");
         	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    		Date fromdate =df.parse(d1);
    		String d2=request.getParameter("todate");
    	    Date todate =df.parse(d2);
    		System.out.println("fromdate"+fromdate);
    		System.out.println("todate"+todate);
            ArrayList<Member> dlist = service.defaultersList(fromdate,todate);
			System.out.println("in controller:"+memberid+":"+category);
            request.setAttribute("dlist", dlist);
            if(dlist!=null)
             { 	
     	         rd1= request.getRequestDispatcher("/defaulters.jsp");
     	         rd1.forward(request, response);
             }
            if(dlist==null)
             {
            	 rd1= request.getRequestDispatcher("/NotFound.jsp");
         	     rd1.forward(request, response);
             }
         }
        //pays fine for the member
		else if ("payment".equals(action))
		{
			System.out.println("in controller pay");
			String d[]=request.getParameterValues("detail");
			double totalFine=0.0;
			String refId[]=new String[d.length];
			for(int i=0;i<d.length;i++)
			{
				System.out.println("without splitting : "+d[i]);
				int count=1;
				for(String svalue:d[i].split("/",2))
			   {
				  if(count==1)
				  {
					 refId[i]=svalue;
					 System.out.println("first : "+svalue);
					 service.payment(refId[i]);
					 count++;
				  }
				  else if(count==2)
				  {
					 System.out.println("second : "+svalue);
					 totalFine=totalFine+Double.parseDouble(svalue);
					 count=1;
				  }
				  else
				  {
					
				  }
			   }
		    }
			request.setAttribute("totalFine", totalFine);
			rd= request.getRequestDispatcher("/successf.jsp");
		    rd.forward(request, response);
	    }
		// cancels fine for the member 
        else if ("cancel".equals(action))
		{
			System.out.println("in controller cancel");
			String[] d=request.getParameterValues("detail");
			double totalFine=0.0;
			String refId[]=new String[d.length];
			for(int i=0;i<d.length;i++)
			{
				System.out.println("without splitting : "+d[i]);
				int count=1;
				for(String svalue:d[i].split("/",2))
			    {
				   if(count==1)
				   {
					  refId[i]=svalue;
					  System.out.println("first : "+svalue);
					  service.cancel(refId[i]);
					  count++;
				   }
				   else if(count==2)
				   {
					 System.out.println("second : "+svalue);
					 totalFine=totalFine+Double.parseDouble(svalue);
					 count=1;
				   }
				   else
				  { }
			   }
			}
		    rd= request.getRequestDispatcher("/finecancellation.jsp");
		    rd.forward(request, response);
	     }
         else
        {
          System.out.println("ERROR");
        }
      }
      catch(Exception e)
       {
        	e.printStackTrace();
       }
           
    }	
        
}

    
    
    


