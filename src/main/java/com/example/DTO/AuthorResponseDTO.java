package com.example.DTO;

import java.util.List;

public class AuthorResponseDTO {
	private long id;
	private String authorName;
    private List<BookResponseDTO> books;
	public AuthorResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorResponseDTO(long id, String authorName, List<BookResponseDTO> books) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.books = books;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public List<BookResponseDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookResponseDTO> books) {
		this.books = books;
	}
    

}
