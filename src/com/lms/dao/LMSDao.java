package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lms.beans.BookBeans;
import com.lms.beans.CDBean;
import com.lms.beans.MagazineBean;
import com.lms.util.DBConnection;

public class LMSDao 
{
	private PreparedStatement pst=null;
	private PreparedStatement pst1=null;
	private PreparedStatement seqPst=null;
	private ResultSet rs=null;
	private Connection conn=null;
	
	public String addBook(BookBeans b) throws SQLException //for adding a book
	{
		int no=0;
		String seq="B";
		conn=DBConnection.getConnection();
		seqPst=conn.prepareStatement("Select book_seq.nextval as referenceID from dual");
		rs=seqPst.executeQuery();
		if(rs.next())
		{
			seq=seq+rs.getString("referenceID");
		}
		String query="insert into tbl_book values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
		
		System.out.println("seq : "+seq);
		System.out.println("ISBN : "+b.getISBN());
		System.out.println("title : "+b.getTitle());
		System.out.println("author : "+b.getAuthor());
		System.out.println("category type : "+b.getCategory());
		System.out.println("sub : "+b.getSubject());
		System.out.println("editor : "+b.getEditor());
		System.out.println("edition : "+b.getEdition());
		System.out.println("cost : "+b.getCost());
		System.out.println("qty : "+b.getQuantity());
		System.out.println("pop : "+b.getPop());
		System.out.println("publisher : "+b.getPublisher());
		System.out.println("yop : "+b.getYop());
		System.out.println("Received Date : "+new java.sql.Date(b.getReceiveDate().getTime()));
		
		pst=conn.prepareStatement(query);
		pst.setString(1, seq);
		pst.setString(2,b.getISBN());
		pst.setString(3,b.getTitle());
		pst.setString(4, b.getCategory());
		pst.setString(5, b.getSubject());
		pst.setString(6, b.getEdition());
		pst.setString(7, b.getAuthor());
		pst.setString(8, b.getEditor());
		pst.setString(9,b.getPublisher());
		pst.setString(10, b.getPop());
		pst.setInt(11, b.getYop());
		pst.setDouble(12, b.getCost());
		pst.setDate(13, new java.sql.Date(b.getReceiveDate().getTime()));
		pst.setInt(14, b.getQuantity());
		pst.setString(15,"no");
		pst.setString(16, "R");
		no=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if(no>0)
			return seq;
		else
			return "no";
	}
	
	
	public String addMagazine(MagazineBean m) throws SQLException //for adding a magaazine
	{
		int no=0;
		String seq="M";
		conn=DBConnection.getConnection();
		seqPst=conn.prepareStatement("Select magazine_seq.nextval as referenceID from dual");
		rs=seqPst.executeQuery();
		if(rs.next())
		{
			seq=seq+rs.getString("referenceID");
		}
		String query="insert into tbl_magazine values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
		pst=conn.prepareStatement(query);
		pst.setString(1, seq);
		pst.setString(2,m.getISBN());
		pst.setString(3,m.getTitle());
		pst.setInt(4, m.getVolumeNo());
		pst.setInt(5, m.getIssueNO());
		pst.setDouble(6, m.getCost());
		pst.setDate(7, new java.sql.Date(m.getDateOfMagazine().getTime()));
		pst.setDate(8, new java.sql.Date(m.getReceiveDate().getTime()));
		pst.setString(9, m.getSubscriptionType());
		pst.setInt(10, m.getQuantity());
		pst.setString(11,"no");
		pst.setString(12,"R");
		no=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if(no>0)
			return seq;
		else
			return "no";
	}


	public String addCD(CDBean cd) throws SQLException //for adding a CD
	{
		
		int no=0;
		String seq="C";
		conn=DBConnection.getConnection();
		seqPst=conn.prepareStatement("Select cd_seq.nextval as referenceID from dual");
		rs=seqPst.executeQuery();
		if(rs.next())
		{
			seq=seq+rs.getString("referenceID");
		}
		String query="insert into tbl_cd values (?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
		pst=conn.prepareStatement(query);
		pst.setString(1, seq);
		pst.setString(2,cd.getTitle());
		pst.setString(3, cd.getSubject());
		pst.setString(4,cd.getPublisher());
		pst.setString(5, cd.getPop());
		pst.setInt(6, cd.getYop());
		pst.setDouble(7, cd.getCost());
		pst.setDate(8, new java.sql.Date(cd.getReceivedDate().getTime()));
		pst.setInt(9, cd.getQuantity());
		pst.setString(10,"no");
		pst.setString(11,"R");
		no=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if(no>0)
			return seq;
		else
			return "no";
	}


	public boolean validateUser(String userID, String pwd) throws SQLException // for validating user
	{
		conn = DBConnection.getConnection();
		String query = "select password from tbl_user where userID=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, userID);
			rs = pst.executeQuery();

			while (rs.next()) 
			{
				if(rs.getString("password").equals(pwd))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		return false;
			
	}

	public boolean deleteBook(String refID) throws SQLException //for deleting a book
	{
		conn = DBConnection.getConnection();
		int rowsDeleted=0;
		String query = "UPDATE tbl_book SET SoftDelete=? WHERE ReferenceID=? and status!='I' and status!='RN'";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "yes");
			pst.setString(2, refID);
			rowsDeleted = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if (rowsDeleted > 0) 
		{
			return true;
		}
		else
			return false;
	}
	public boolean deleteMagazine(String refID) throws SQLException //for deleting magazine
	{
		conn = DBConnection.getConnection();
		int rowsDeleted=0;
		String query = "UPDATE tbl_magazine SET SoftDelete=? WHERE ReferenceID=? and status!='I' and status!='RN'";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "yes");
			pst.setString(2, refID);
			rowsDeleted = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if (rowsDeleted > 0) 
		{
			return true;
		}
		else
			return false;
	}
	public boolean deleteCD(String refID) throws SQLException //for deleting CD
	{
		conn = DBConnection.getConnection();
		int rowsDeleted=0;
		String query = "UPDATE tbl_CD SET SoftDelete=? WHERE ReferenceID=? and status!='I' and status!='RN'";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "yes");
			pst.setString(2, refID);
			rowsDeleted = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if (rowsDeleted > 0) 
		{
			return true;
		}
		else
			return false;
	}


	public ArrayList<BookBeans> searchBookByID(String refID) throws SQLException //for searching book 
	{
		ArrayList<BookBeans> bookList = new ArrayList<BookBeans>();
		conn = DBConnection.getConnection();
		String query = "select * from tbl_book where ReferenceID=?";
		try 
		{
			pst = conn.prepareStatement(query);
			pst.setString(1, refID);
			rs = pst.executeQuery();
			while (rs.next()) 
			{
				BookBeans b=new BookBeans();
				b.setReferenceID(rs.getString(1));
				b.setISBN(rs.getString(2));
				b.setTitle(rs.getString(3));
				b.setCategory(rs.getString(4));
				b.setSubject(rs.getString(5));
				b.setEdition(rs.getString(6));
				b.setAuthor(rs.getString(7));
				b.setEditor(rs.getString(8));
				b.setPublisher(rs.getString(9));
				b.setPop(rs.getString(10));
				b.setYop(rs.getInt(11));
				b.setCost(rs.getDouble(12));
				b.setReceiveDate(rs.getDate(13));
				b.setQuantity(rs.getInt(14));
				b.setSoftDelete(rs.getString(15));
				bookList.add(b);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		return bookList;
	}


	public String updateBook(BookBeans b) throws SQLException //for updating book
	{
		conn = DBConnection.getConnection();
		int no=0;
		System.out.println("Received Date : "+new java.sql.Date(b.getReceiveDate().getTime()));
		String query = "UPDATE tbl_book SET ReferenceID=?,ISBN=?,Title=?,Type=?,Subject=?,Edition=?,Author=?,Editor=?,Publisher=?,PlaceOfPublication=?,YearOfPublictaion=?,Cost=?,ReceiveDate=?,Quantity=?,SoftDelete=? WHERE ReferenceID=?";
		try
		{	
		pst=conn.prepareStatement(query);
		pst.setString(1, b.getReferenceID());
		pst.setString(2,b.getISBN());
		pst.setString(3,b.getTitle());
		pst.setString(4, b.getCategory());
		pst.setString(5, b.getSubject());
		pst.setString(6, b.getEdition());
		pst.setString(7, b.getAuthor());
		pst.setString(8, b.getEditor());
		pst.setString(9,b.getPublisher());
		pst.setString(10, b.getPop());
		pst.setInt(11, b.getYop());
		pst.setDouble(12, b.getCost());
		pst.setDate(13, new java.sql.Date(b.getReceiveDate().getTime()));
		pst.setInt(14, b.getQuantity());
		pst.setString(15,b.getSoftDelete());
		pst.setString(16, b.getReferenceID());
		no=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		query = "UPDATE statusreportt SET ISBN_CDNO_VOLNO=? WHERE refid=?";
		try
		{	
			
		pst1=conn.prepareStatement(query);
		pst1.setString(1,b.getISBN());
		pst1.setString(2, b.getReferenceID());
		pst1.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if(no>0)
			return b.getReferenceID();
		else
			return "no";
	}
	
	
	public ArrayList<CDBean> searchCDByID(String refID) throws SQLException //for searching CD
	{
		ArrayList<CDBean> CDList = new ArrayList<CDBean>();
		conn = DBConnection.getConnection();
		String query = "select * from tbl_cd where ReferenceID=?";
		try 
		{
			pst = conn.prepareStatement(query);
			pst.setString(1, refID);
			rs = pst.executeQuery();
			while (rs.next()) 
			{
				CDBean c=new CDBean();
				c.setReferenceID(rs.getString(1));
				c.setTitle(rs.getString(2));
				c.setSubject(rs.getString(3));
				c.setPublisher(rs.getString(4));
				c.setPop(rs.getString(5));
				c.setYop(rs.getInt(6));
				c.setCost(rs.getDouble(7));
				c.setReceivedDate(rs.getDate(8));
				c.setQuantity(rs.getInt(9));
				c.setSoftDelete(rs.getString(10));
				CDList.add(c);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		return CDList;
	}

	public String updateCD(CDBean c) throws SQLException //for updating CD
	{
		
		System.out.println("title : "+c.getTitle());
		System.out.println("sub : "+c.getSubject());
		System.out.println("cost : "+c.getCost());
		System.out.println("qty : "+c.getQuantity());
		System.out.println("pop : "+c.getPop());
		System.out.println("publisher : "+c.getPublisher());
		System.out.println("yop : "+c.getYop());
		System.out.println("Received Date : "+new java.sql.Date(c.getReceivedDate().getTime()));
		
		conn = DBConnection.getConnection();
		int no=0;
		String query = "UPDATE tbl_cd SET ReferenceID=?,Title=?,Subject=?,Publisher=?,PlaceOfPublication=?,YearOfPublictaion=?,Cost=?,ReceiveDate=?,Quantity=?,SoftDelete=? WHERE ReferenceID=?";
		try
		{		
		pst=conn.prepareStatement(query);
		pst.setString(1, c.getReferenceID());
		pst.setString(2,c.getTitle());
		pst.setString(3, c.getSubject());
		pst.setString(4,c.getPublisher());
		pst.setString(5, c.getPop());
		pst.setInt(6,c.getYop());
		pst.setDouble(7, c.getCost());
		pst.setDate(8, new java.sql.Date(c.getReceivedDate().getTime()));
		pst.setInt(9, c.getQuantity());
		pst.setString(10,c.getSoftDelete());
		pst.setString(11, c.getReferenceID());
		no=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		query = "UPDATE statusreportt SET ISBN_CDNO_VOLNO=? WHERE refid=?";
		try
		{	
			
		pst1=conn.prepareStatement(query);
		pst1.setString(1,c.getReferenceID());
		pst1.setString(2, c.getReferenceID());
		pst1.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if(no>0)
			return c.getReferenceID();
		else
			return "no";
	}


	public ArrayList<MagazineBean> searchMagazineByID(String refID) throws SQLException //for searching magazine
	{
		ArrayList<MagazineBean> MagazineList = new ArrayList<MagazineBean>();
		conn = DBConnection.getConnection();
		String query = "select * from tbl_magazine where ReferenceID=?";
		try 
		{
			pst = conn.prepareStatement(query);
			pst.setString(1, refID);
			rs = pst.executeQuery();
			while (rs.next()) 
			{
				MagazineBean m=new MagazineBean();
				m.setReferenceID(rs.getString(1));
				m.setISBN(rs.getString(2));
				m.setTitle(rs.getString(3));
				m.setVolumeNo(rs.getInt(4));
				m.setIssueNO(rs.getInt(5));
				m.setCost(rs.getDouble(6));
				m.setDateOfMagazine(rs.getDate(7));
				m.setReceiveDate(rs.getDate(8));
				m.setSubscriptionType(rs.getString(9));
				m.setQuantity(rs.getInt(10));
				m.setSoftDelete(rs.getString(11));
				MagazineList.add(m);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		return MagazineList;
	}
	
	
	public String updateMagazine(MagazineBean m) throws SQLException //for updating magazine
	{
		conn = DBConnection.getConnection();
		int no=0;
		
		String query = "UPDATE tbl_magazine SET ReferenceID=?,ISBN=?,Title=?,VolumeNo=?,IssueNo=?,Cost=?,DateOfMagazine=?,ReceiveDate=?,SubscriptionType=?,Quantity=?,SoftDelete=? WHERE ReferenceID=?";
		try
		{	
			System.out.println("ISBN : "+m.getISBN());
			System.out.println("Title : "+m.getTitle());
			System.out.println("Volume no : "+m.getVolumeNo());
			System.out.println("Issue no : "+m.getIssueNO());
			System.out.println("cost : "+m.getCost());
			System.out.println("Date Of Magazine : "+new java.sql.Date(m.getDateOfMagazine().getTime()));
			System.out.println("Received Date : "+new java.sql.Date(m.getReceiveDate().getTime()));
			System.out.println("Subscription type : "+m.getSubscriptionType());
			System.out.println("qty : "+m.getQuantity());
		pst=conn.prepareStatement(query);
		pst.setString(1, m.getReferenceID());
		pst.setString(2,m.getISBN());
		pst.setString(3,m.getTitle());
		pst.setInt(4, m.getVolumeNo());
		pst.setInt(5, m.getIssueNO());
		pst.setDouble(6, m.getCost());
		pst.setDate(7, new java.sql.Date(m.getDateOfMagazine().getTime()));
		pst.setDate(8, new java.sql.Date(m.getReceiveDate().getTime()));
		pst.setString(9, m.getSubscriptionType());
		pst.setInt(10, m.getQuantity());
		pst.setString(11,m.getSoftDelete());
		pst.setString(12, m.getReferenceID());
		no=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		query = "UPDATE statusreportt SET ISBN_CDNO_VOLNO=? WHERE refid=?";
		try
		{	
			
		pst1=conn.prepareStatement(query);
		pst1.setString(1,m.getISBN());
		pst1.setString(2, m.getReferenceID());
		pst1.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DBConnection.CloseConnection(conn);
		}
		if(no>0)
			return m.getReferenceID();
		else
			return "no";
	}
	
}
