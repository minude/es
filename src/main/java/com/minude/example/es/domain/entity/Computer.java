package com.minude.example.es.domain.entity;

import com.minude.example.es.domain.model.ComputerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-28 11:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "computer", type = "computer")
public class Computer {

    @Id
    private String id;
    private String brand;
    private String model;
    private Double price;

    public Computer(ComputerDto computerDto) {

        this.brand = computerDto.getBrand();
        this.model = computerDto.getModel();
        this.price = computerDto.getPrice();
    }

    public ComputerDto transferDto() {

        ComputerDto dto = new ComputerDto();
        dto.setId(this.id);
        dto.setBrand(this.brand);
        dto.setModel(this.model);
        dto.setPrice(this.price == null ? 0D : this.price);
        return dto;
    }
}
