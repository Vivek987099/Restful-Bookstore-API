package com.example.service;

import java.util.List;

import com.example.DTO.AuthorDTO;
import com.example.DTO.AuthorResponseDTO;
import com.example.DTO.AuthorWithoutBookDTO;

public interface AuthorService {
	public AuthorResponseDTO createNewAuthor(AuthorDTO authorDTO);
	public List<AuthorResponseDTO> getAllAuthor(int pageNo,int pageSize);
	public AuthorResponseDTO getAuthorById(long id);
	public AuthorResponseDTO createAuthorWithoutBook(AuthorWithoutBookDTO authorWithoutBookDTO);

}
