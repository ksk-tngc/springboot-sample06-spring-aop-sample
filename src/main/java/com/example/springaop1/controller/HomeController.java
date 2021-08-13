package com.example.springaop1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * トップページのコントローラ。
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * トップページ。
     */
    @GetMapping
    public String index() {
        return "index";
    }

}
