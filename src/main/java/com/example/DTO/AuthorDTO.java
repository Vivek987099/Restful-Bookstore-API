package com.example.DTO;
import java.util.List;


public class AuthorDTO {
	private String authorName;
    private List<BookDTO> books;
	public AuthorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorDTO( String authorName, List<BookDTO> books) {
		super();
		this.authorName = authorName;
		this.books = books;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}


}
