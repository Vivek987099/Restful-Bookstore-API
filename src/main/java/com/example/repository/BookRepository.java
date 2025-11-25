package com.example.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitle(Pageable pageable, String title);

}
