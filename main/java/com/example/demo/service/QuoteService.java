package com.example.demo.service;
import java.util.List;
public interface QuoteService {
String getRandomQuote();
    List<Quote> getAllQuotes();

    void addQuote(Quote quote);
}
