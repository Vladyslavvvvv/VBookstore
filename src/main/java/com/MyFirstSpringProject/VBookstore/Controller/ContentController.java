package com.MyFirstSpringProject.VBookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/req/registration")
    public String register() {
        return "registration";
    }

    @GetMapping("/req/books")
    public String books() {
        return "books";
    }
}
