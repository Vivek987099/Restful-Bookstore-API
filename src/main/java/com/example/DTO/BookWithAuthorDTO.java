package com.example.DTO;

public class BookWithAuthorDTO {
	private String title;
	private Double price;
	private Long authorId;

	public BookWithAuthorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookWithAuthorDTO(String title, Double price, Long authorId) {
		super();
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

}
