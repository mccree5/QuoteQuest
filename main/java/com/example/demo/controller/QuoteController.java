package com.example.demo.controller;

import com.example.demo.service.QuoteServiceMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.Quote;
import com.example.demo.service.QuoteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {
    private final QuoteService quoteService;
    private final QuoteServiceMemory quoteServiceMemory;
    @Autowired
    public QuoteController(QuoteService quoteService, QuoteServiceMemory quoteServiceMemory) {
        this.quoteService = quoteService;
        this.quoteServiceMemory = quoteServiceMemory;
    }

    @GetMapping("/allquotes")
    public List<Quote> getAllQuotes(){

    return quoteService.getAllQuotes();}

    @GetMapping("/randomquotes")
    public String getRandomQuote(){

    return quoteService.getRandomQuote();}

    @PostMapping("/addQuotes")
    public void addQuote(@RequestBody Quote quote) {
        quoteServiceMemory.addQuote(quote);
    }




}
