package com.example.service;

import java.util.List;

import com.example.DTO.BookResponseDTO;
import com.example.DTO.BookWithAuthorDTO;

public interface BookService {
//	GET ALL BOOKS
	public List<BookResponseDTO> getAllBooks(int pageNo, int pageSize, String sortBy, String title);

//  GET BOOK BY ID
	public BookResponseDTO getBookById(long id);

//  DELETE BOOK BY ID
	public BookResponseDTO deleteBookById(long id);

//  UPDATE BOOK BY ID
	public BookResponseDTO updateBookById(long id, BookWithAuthorDTO bookWithAuthorDTO);

//  CREATE NEW BOOK
	public BookResponseDTO createBook(BookWithAuthorDTO bookWithAuthorDTO);

}
