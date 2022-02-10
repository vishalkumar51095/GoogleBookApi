package com.vishalkumar51095.GoogleBookApi.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/home")
    public String home() {
        return "Book";
    }



}
