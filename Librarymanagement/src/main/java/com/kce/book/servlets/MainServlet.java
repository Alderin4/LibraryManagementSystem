package com.kce.book.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kce.book.bean.BookBean;
import com.kce.book.dao.AuthorDAO;
import com.kce.book.service.Administrator;

import java.io.IOException;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		if(operation.equals("AddBook")) {
			String result=addBook(request);
			if(result.equals("SUCCESS")) {
				response.sendRedirect("Menu.html");
			}
			else if(result.equals("INVALID")) {
				response.sendRedirect("Invalid.html");
			}else if(result.equals("FAILURE")) {
				response.sendRedirect("Failure.html");
			}
		}
		else if()
		}
	public String addbook (HttpServletRequest request) {
		String isbn=request.getParameter("isbn");
		String bookName=request.getParameter("bookname");
		String bookType=request.getParameter("booktype");
		String authorName=request.getParameter("authorName");
		String cost=request.getParameter("cost");
		BookBean bookBean=new BookBean();
		bookBean.setIsbn(isbn);
		bookBean.setBookName(bookName);
		bookBean.setBooktype(bookType.charAt(0));
		bookBean.setCost(Float.parseFloat(cost));
		bookBean.setAuthor(new AuthorDAO().getAuthorByCode(authorName));
		String result=new Administrator().addBook(bookBean);
		return result;
	}
    public BookBean viewbook(String isbn) {
    	Administrator admin=new Administrator();
    	return admin.viewbook(isbn);
    }
}