package com.example.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DTO.AuthorDTO;
import com.example.DTO.AuthorResponseDTO;
import com.example.DTO.AuthorWithoutBookDTO;
import com.example.DTO.BookDTO;
import com.example.DTO.BookResponseDTO;
import com.example.entity.Author;
import com.example.entity.Book;
import com.example.exception.ResourcesNotFoundException;
import com.example.repository.AuthorRepository;
import com.example.service.AuthorService;

@Service
public class AuthorServiceImple implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	private AuthorResponseDTO convertAuthorResponseDTO(Author author) {

		List<BookResponseDTO> bookDTOs = new ArrayList<>();
		for (Book book : author.getBooks()) {
			BookResponseDTO dto = new BookResponseDTO(book.getId(), book.getTitle(), book.getPrice(), book.getAuthor().getId());
			bookDTOs.add(dto);

		}

		return new AuthorResponseDTO(author.getId(), author.getAuthorName(), bookDTOs);

	}

	@Override
	public AuthorResponseDTO createNewAuthor(AuthorDTO authorDTO) {

		Author author = new Author();
		author.setAuthorName(authorDTO.getAuthorName());
		List<Book> bookList = new ArrayList<>();
		for (BookDTO bookDTO : authorDTO.getBooks()) {
			Book book = new Book();
			book.setTitle(bookDTO.getTitle());
			book.setPrice(bookDTO.getPrice());
			book.setAuthor(author);
			bookList.add(book);

		}
		author.setBooks(bookList);
		Author savedAuthor = authorRepository.save(author);
		return convertAuthorResponseDTO(savedAuthor);

		

	}
	@Override
	public List<AuthorResponseDTO> getAllAuthor(int pageNo,int pageSize) {
		  Pageable pageable= PageRequest.of(pageNo, pageSize);
		
		List<AuthorResponseDTO> authorResponseDTOsList= new ArrayList<>();
		  List<Author> authorsList= authorRepository.findAll(pageable).getContent();
		  for (Author author : authorsList) {
			 AuthorResponseDTO dto= convertAuthorResponseDTO(author);
			 authorResponseDTOsList.add(dto);
			
		}
		  return authorResponseDTOsList;
		
		
	}
	
	@Override
	public AuthorResponseDTO getAuthorById(long id) {
		  Author author=  authorRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Author not found with this id "+id));
		return convertAuthorResponseDTO(author);
	}
	
	@Override
	public AuthorResponseDTO createAuthorWithoutBook(AuthorWithoutBookDTO authorWithoutBookDTO) {
		Author author = new Author(authorWithoutBookDTO.getAuthorName());
		Author savedAuthor =  authorRepository.save(author);
		
		return new AuthorResponseDTO(savedAuthor.getId(), savedAuthor.getAuthorName(), null);

	}

}
