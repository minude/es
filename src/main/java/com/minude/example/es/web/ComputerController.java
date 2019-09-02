package com.minude.example.es.web;

import com.minude.example.es.domain.model.ComputerDto;
import com.minude.example.es.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:39
 */
@RestController
@RequestMapping("/computers")
public class ComputerController {

    private ComputerService computerService;

    @Autowired
    public void setComputerService(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping
    public ComputerDto save(ComputerDto computer) {

        return computerService.save(computer);
    }

    @DeleteMapping
    public Boolean delete(String id) {

        return computerService.delete(id);
    }

    @PutMapping
    public Boolean update(ComputerDto computer) {

        return computerService.update(computer);
    }

    @GetMapping("/{id}")
    public ComputerDto detail(@PathVariable("id") String id) {

        return computerService.detail(id);
    }

    @GetMapping
    public List<ComputerDto> list(String keyword, @PageableDefault Pageable pageable) {

        return computerService.list(keyword, pageable);
    }

}
