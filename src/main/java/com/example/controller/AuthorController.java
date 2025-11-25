package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.AuthorDTO;
import com.example.DTO.AuthorWithoutBookDTO;
import com.example.service.AuthorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/author")
@Tag(name = "Author API's")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
//	CREATE AUTHOR WITH BOOK
	@PostMapping("create-author-with-book")
	public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO authorDTO) {
		return ResponseEntity.ok(authorService.createNewAuthor(authorDTO));
		
	}
//	GET ALL AUTHORS 
	@GetMapping("/all-authors")
	public ResponseEntity<?> getAuthors(@RequestParam(name = "pageNo" ,defaultValue = "0") int pageNo, @RequestParam(name = "pageSize" ,defaultValue = "3") int pageSize){
		return ResponseEntity.ok(authorService.getAllAuthor(pageNo,pageSize));
	}
//	GET AUTHOR BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getAuthorWithId(@PathVariable long id){
		return ResponseEntity.ok(authorService.getAuthorById(id));
	}
	
//	CREATE AUTHOR WITHOUT BOOK
	@PostMapping("/create-author-without-book")
	public ResponseEntity<?> createWithoutBook(@RequestBody AuthorWithoutBookDTO authorWithoutBookDTO){
		return ResponseEntity.ok(authorService.createAuthorWithoutBook(authorWithoutBookDTO));
	}

}
