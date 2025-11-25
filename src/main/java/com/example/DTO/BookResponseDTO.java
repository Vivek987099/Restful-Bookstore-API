package com.example.DTO;

public class BookResponseDTO {
	private long id;
	private String title;
	private Double price;
	private Long authorId;

	public BookResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookResponseDTO(long id, String title, Double price, Long authorId) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
