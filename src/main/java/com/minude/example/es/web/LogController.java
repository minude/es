package com.minude.example.es.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-30 14:11
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping
    public String log(String msg) {

        log.info(msg);
        return "success";
    }
}
