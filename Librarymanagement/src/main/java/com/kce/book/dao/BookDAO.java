package com.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.kce.book.bean.*;
import com.kce.book.util.*;

public class BookDAO {
private Connection con=DBUtil.getDBConnection();
public int createBook(BookBean bookBean) {
	int result=0;
	try {
		PreparedStatement ps =con.prepareStatement("Insert into book_tbl values(?,?,?,?,?");
		ps.setString(1, bookBean.getIsbn());
        ps.setString(2, bookBean.getBookName());
        ps.setString(3, String.valueOf(bookBean.getBooktype())); 
        ps.setFloat(4, bookBean.getAuthor().getAuthorcode());
        ps.setDouble(5, bookBean.getCost());

        int rows = ps.executeUpdate();
        if (rows > 0) {
            result = 1; 
        }

    } catch (SQLException e) {
        e.printStackTrace(); 
        result = 0; 
    }

    return result;
}
public BookBean fetchBook(String isbn) {
    BookBean book = null;
    Connection con = DBUtil.getDBConnection();
    String query = "SELECT * FROM book_tbl WHERE isbn=?";
    try { 
    	PreparedStatement ps = con.prepareStatement(query); 
    	ps.setString(1, isbn);
    	ResultSet rs = ps.executeQuery();
    	if(rs.next()) {
			book = new BookBean();
			book.setIsbn(rs.getString("isbn"));
			book.setBookName(rs.getString("book_title"));
			book.setBooktype(rs.getString("book_type").charAt(0));
			book.setCost(rs.getFloat("book_cost"));
			int authorCode = rs.getInt("author_code");
			AuthorDAO authorDAO = new AuthorDAO();
			AuthorBean author = authorDAO.getAuthorByCode(authorCode);
			book.setAuthor(author);
			return book;
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return book;
}
}