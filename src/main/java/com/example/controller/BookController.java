package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.BookWithAuthorDTO;
import com.example.service.BookService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book")
@Tag(name = "Book API's")
public class BookController {
	@Autowired
	private BookService bookService;

//	ALL BOOKS
	@GetMapping("/all-books")
	public ResponseEntity<?> getBook(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "title") String sortBy,
			@RequestParam(name = "byTitle", required = false) String title) {
		return ResponseEntity.ok(bookService.getAllBooks(pageNo, pageSize, sortBy, title));

	}

//  GET BOOK BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> bookById(@PathVariable long id) {
		return ResponseEntity.ok(bookService.getBookById(id));
	}

//  DELETE BOOK BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBookWithId(@PathVariable long id) {
		return ResponseEntity.ok(bookService.deleteBookById(id));
	}

//  UPDATE BOOK
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable long id, BookWithAuthorDTO bookWithAuthorDTO) {
		return ResponseEntity.ok(bookService.updateBookById(id, bookWithAuthorDTO));
	}

//  CREATE BOOK
	@PostMapping("/create-book")
	public ResponseEntity<?> createBook(@RequestBody BookWithAuthorDTO bookWithAuthorDTO) {
		return ResponseEntity.ok(bookService.createBook(bookWithAuthorDTO));

	}

}
