package com.lms.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lms.beans.BookBeans;
import com.lms.beans.CDBean;
import com.lms.beans.MagazineBean;
import com.lms.dao.LMSDao;

public class LMSServices 
{
	public String addBook(BookBeans b) throws SQLException//add book
	{
		LMSDao dao=new LMSDao();
		return dao.addBook(b);
	}

	public String addMagazine(MagazineBean m) throws SQLException //add magazine
	{
		LMSDao dao=new LMSDao();
		return dao.addMagazine(m);
	}

	public String addCD(CDBean cd) throws SQLException //addCD
	{
		LMSDao dao=new LMSDao();
		return dao.addCD(cd);
	}

	public boolean validateUser(String userID, String pwd) throws SQLException //validateUser
	{
		LMSDao dao=new LMSDao();
		return dao.validateUser(userID,pwd); 
	}

	public boolean deleteBook(String refID) throws SQLException //deleteBook
	{
		LMSDao dao=new LMSDao();
		return dao.deleteBook(refID);
	}	
	public boolean deleteMagazine(String refID) throws SQLException //deleteMagazine
	{
		LMSDao dao=new LMSDao();
		return dao.deleteMagazine(refID);
	}	
	public boolean deleteCD(String refID) throws SQLException //deleteCD
	{
		LMSDao dao=new LMSDao();
		return dao.deleteCD(refID);
	}

	public ArrayList<BookBeans> searchBookByID(String refID) throws SQLException//searchBook
	{
		LMSDao dao=new LMSDao();
		return dao.searchBookByID(refID);
	}

	public String updateBook(BookBeans book) throws SQLException {//updateBook
		LMSDao dao=new LMSDao();
		return dao.updateBook(book);
	}	
	
	public ArrayList<CDBean> searchCDByID(String refID) throws SQLException//searchCD
	{
		LMSDao dao=new LMSDao();
		return dao.searchCDByID(refID);
	}

	public String updateCD(CDBean cd) throws SQLException {//updateCD
		LMSDao dao=new LMSDao();
		return dao.updateCD(cd);
	}

	public ArrayList<MagazineBean> searchMagazineByID(String refID) throws SQLException //searchMagazine
	{
		LMSDao dao=new LMSDao();
		return dao.searchMagazineByID(refID);
	}	
	
	public String updateMagazine(MagazineBean Magazine) throws SQLException {//updateMagazine
		LMSDao dao=new LMSDao();
		return dao.updateMagazine(Magazine);
	}	
	
	
}