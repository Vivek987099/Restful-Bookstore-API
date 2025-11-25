package com.example.serviceImple;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.DTO.BookResponseDTO;
import com.example.DTO.BookWithAuthorDTO;
import com.example.entity.Author;
import com.example.entity.Book;
import com.example.exception.ResourcesNotFoundException;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import com.example.service.BookService;

@Service
public class BookServiceImple implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

//	GET BOOK
	@Override
	public List<BookResponseDTO> getAllBooks(int pageNo, int pageSize, String sortBy, String title) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<BookResponseDTO> bookDTOsList = new ArrayList<>();
		List<Book> bookList = new ArrayList<>();

		if (title != null) {
			bookList = bookRepository.findByTitle(pageable, title);
		} else {
			bookList = bookRepository.findAll(pageable).getContent();
		}

		for (Book book : bookList) {
			BookResponseDTO dto = new BookResponseDTO(book.getId(), book.getTitle(), book.getPrice(),
					book.getAuthor().getId());
			bookDTOsList.add(dto);
		}
		return bookDTOsList;
	}

//  GET BOOK BY ID
	@Override
	public BookResponseDTO getBookById(long id) {

		Book b = bookRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Book Not found with this " + id));
		return new BookResponseDTO(b.getId(), b.getTitle(), b.getPrice(), b.getAuthor().getId());
	}

//  DELETE BOOK BY ID
	@Override
	public BookResponseDTO deleteBookById(long id) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Book not found with this id " + id));
		bookRepository.delete(book);
		return new BookResponseDTO(book.getId(), book.getTitle(), book.getPrice(), book.getAuthor().getId());

	}

//  UPDATE BOOK BY ID
	@Override
	public BookResponseDTO updateBookById(long id, BookWithAuthorDTO bookWithAuthorDTO) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Book not found with this id " + id));
		if (bookWithAuthorDTO.getTitle() != null) {
			book.setTitle(bookWithAuthorDTO.getTitle());
		}
		if (bookWithAuthorDTO.getPrice() != null) {
			book.setPrice(bookWithAuthorDTO.getPrice());
		}
		if (bookWithAuthorDTO.getAuthorId() != null) {
			Author opAuthor = authorRepository.findById(bookWithAuthorDTO.getAuthorId())
					.orElseThrow(() -> new ResourcesNotFoundException(
							"Author not found with this id " + bookWithAuthorDTO.getAuthorId()));
			book.setAuthor(opAuthor);
		}
		Book savedBook = bookRepository.save(book);
		return new BookResponseDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getPrice(),
				savedBook.getAuthor().getId());

	}

//  CREATE BOOK
	@Override
	public BookResponseDTO createBook(BookWithAuthorDTO bookWithAuthorDTO) {
		Book book = new Book();
		Author author = authorRepository.findById(bookWithAuthorDTO.getAuthorId())
				.orElseThrow(() -> new ResourcesNotFoundException(
						"Author not found with this id " + bookWithAuthorDTO.getAuthorId()));
		book.setTitle(bookWithAuthorDTO.getTitle());
		book.setPrice(bookWithAuthorDTO.getPrice());
		book.setAuthor(author);
		Book savedBook = bookRepository.save(book);
		return new BookResponseDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getPrice(),
				savedBook.getAuthor().getId());
	}

}
