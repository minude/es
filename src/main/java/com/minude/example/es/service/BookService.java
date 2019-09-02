package com.minude.example.es.service;

import com.minude.example.es.domain.model.BookDto;

import java.util.List;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:38
 */
public interface BookService {

    /**
     * save a new book
     *
     * @param dto book info
     * @return persist book info
     */
    BookDto save(BookDto dto);

    /**
     * delete a book
     *
     * @param id book id to be delete
     * @return delete result
     */
    Boolean delete(String id);

    /**
     * update book info
     *
     * @param dto book info
     * @return persist book info
     */
    Boolean update(BookDto dto);

    /**
     * search a book with it`s id
     *
     * @param id book id
     * @return book info
     */
    BookDto detail(String id);

    /**
     * get all books
     *
     * @return all books
     */
    List<BookDto> list();

}
