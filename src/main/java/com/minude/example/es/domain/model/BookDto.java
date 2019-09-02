package com.minude.example.es.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    private String name;
    private double price;
}
