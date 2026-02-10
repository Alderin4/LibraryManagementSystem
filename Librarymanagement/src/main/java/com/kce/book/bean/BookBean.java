package com.kce.book.bean;

public class BookBean {
	private String isbn;
	private String BookName;
	private AuthorBean Author;
	private char booktype;
	private float cost;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public AuthorBean getAuthor() {
		return Author;
	}
	public void setAuthor(AuthorBean author) {
		Author = author;
	}
	public char getBooktype() {
		return booktype;
	}
	public void setBooktype(char booktype) {
		this.booktype = booktype;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
}