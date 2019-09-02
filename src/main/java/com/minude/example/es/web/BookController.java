package com.minude.example.es.web;

import com.minude.example.es.domain.model.BookDto;
import com.minude.example.es.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:39
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDto save(BookDto book) {

        return bookService.save(book);
    }

    @DeleteMapping
    public Boolean delete(String id) {

        return bookService.delete(id);
    }

    @PutMapping
    public Boolean update(BookDto book) {

        return bookService.update(book);
    }

    @GetMapping("/{id}")
    public BookDto detail(@PathVariable("id") String id) {

        return bookService.detail(id);
    }

    @GetMapping
    public List<BookDto> list() {

        return bookService.list();
    }

}
