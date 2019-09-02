package com.minude.example.es.service.impl;

import com.minude.example.es.domain.entity.Book;
import com.minude.example.es.domain.model.BookDto;
import com.minude.example.es.domain.repository.BookRepository;
import com.minude.example.es.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:39
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto save(BookDto dto) {

        Book newBook = new Book(dto);
        Book persist = bookRepository.save(newBook);
        return persist.transferDto();
    }

    @Override
    public Boolean delete(String id) {

        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(BookDto dto) {

        Optional<Book> optional = bookRepository.findById(dto.getId());
        if (optional.isPresent()) {

            Book book = optional.get();
            book.setName(dto.getName());
            book.setPrice(dto.getPrice());
            bookRepository.save(book);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BookDto detail(String id) {

        Optional<Book> optional = bookRepository.findById(id);
        return optional.map(Book::transferDto).orElse(null);
    }

    @Override
    public List<BookDto> list() {

        Iterable<Book> books = bookRepository.findAll();
        List<BookDto> dtos = new ArrayList<>();
        books.forEach(book -> dtos.add(book.transferDto()));
        return dtos;
    }
}
