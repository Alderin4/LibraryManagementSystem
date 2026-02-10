package com.kce.book.service;
import com.kce.book.bean.BookBean;
import com.kce.book.bean.AuthorBean;
import com.kce.book.dao.BookDAO;

public class Administrator {
public String addBook(BookBean bookBean) {
	if (
		    bookBean == null ||
		    bookBean.getBookName() == null || bookBean.getBookName().trim().isEmpty() ||
		    bookBean.getIsbn() == null || bookBean.getIsbn().trim().isEmpty() ||
		    bookBean.getBooktype() == ' ' ||
		    (bookBean.getBooktype() != 'g' && bookBean.getBooktype() != 't') ||
		    bookBean.getCost() == 0 ||
		    bookBean.getAuthor() == null ||
		    bookBean.getAuthor().getAuthorName() == null ||
		    bookBean.getAuthor().getAuthorName().trim().isEmpty()
		) {
		    return "Invalid";
		}
	BookDAO bookDAO =new BookDAO();
	int result=bookDAO.createBook(bookBean);
	if(result==1) {
		return "Success"; 
	}else {
		return "Failure";
	}
			
}
public BookBean viewbook(String isbn) {
	if(isbn==null|| isbn.isEmpty()) {
		return null;
	}
	BookDAO bookdao=new BookDAO();
	BookBean bookbean=bookdao.fetchBook(isbn);
	return bookbean;
}
}