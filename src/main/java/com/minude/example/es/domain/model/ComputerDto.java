package com.minude.example.es.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-28 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDto {

    private String id;
    private String brand;
    private String model;
    private double price;

}
