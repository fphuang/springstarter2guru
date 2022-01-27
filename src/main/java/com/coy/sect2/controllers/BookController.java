package com.coy.sect2.controllers;

import com.coy.sect2.domain.Book;
import com.coy.sect2.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(path="")
    public String getBooks(Model model) {
        var result = bookRepository.findAll();
        Model books = model.addAttribute("books", result);
        return "books/list";
    }
}
