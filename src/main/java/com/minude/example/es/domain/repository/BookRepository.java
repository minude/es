package com.minude.example.es.domain.repository;

import com.minude.example.es.domain.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:34
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
}
