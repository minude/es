package com.minude.example.es.service;

import com.minude.example.es.domain.model.ComputerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:38
 */
public interface ComputerService {

    /**
     * save a new computer
     *
     * @param dto computer info
     * @return persist computer info
     */
    ComputerDto save(ComputerDto dto);

    /**
     * delete a computer
     *
     * @param id computer id to be delete
     * @return delete result
     */
    Boolean delete(String id);

    /**
     * update computer info
     *
     * @param dto computer info
     * @return persist computer info
     */
    Boolean update(ComputerDto dto);

    /**
     * search a computer with it`s id
     *
     * @param id computer id
     * @return computer info
     */
    ComputerDto detail(String id);

    /**
     * get all computers
     *
     * @param keyword to search
     * @param pageable page info
     * @return all computers
     */
    List<ComputerDto> list(String keyword, Pageable pageable);

}
