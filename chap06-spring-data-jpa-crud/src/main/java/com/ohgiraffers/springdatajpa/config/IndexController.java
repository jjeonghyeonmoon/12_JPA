package com.ohgiraffers.springdatajpa.config;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage(){
        return "main/mian";
    }
}
