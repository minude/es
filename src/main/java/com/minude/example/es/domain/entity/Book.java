package com.minude.example.es.domain.entity;

import com.minude.example.es.domain.model.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "book", type = "book")
public class Book {

    @Id
    private String id;
    private String name;
    private Double price;

    public Book(BookDto bookDto) {

        this.name = bookDto.getName();
        this.price = bookDto.getPrice();
    }

    public BookDto transferDto() {

        BookDto dto = new BookDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setPrice(this.price == null ? 0D : this.price);
        return dto;
    }

}
