package com.example.demo.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import java.util.Random;

@Service
public class QuoteServiceMemory implements QuoteService {

    private final List<Quote> quoteList = new ArrayList<>();

    public QuoteServiceMemory() {
        loadQuotesFromFile();
    }


    private void loadQuotesFromFile() {

            try (
                    InputStream inputStream = new ClassPathResource("quote.txt").getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.isEmpty()) {
                        continue;
                    }
                    JsonObject jsonObject = JsonParser.parseString(line).getAsJsonObject();
                    String id = jsonObject.get("_id").getAsString();
                    String author = jsonObject.get("author").getAsString();
                    String content = jsonObject.get("content").getAsString();
                    String authorSlug = jsonObject.get("authorSlug").getAsString();
                    int length = jsonObject.get("length").getAsInt();
                    String dateAdded = jsonObject.get("dateAdded").getAsString();
                    String dateModified = jsonObject.get("dateModified").getAsString();
                    Quote quote = new Quote(id, content, author, authorSlug, length, dateAdded, dateModified);
                    quoteList.add(quote);
                    System.out.println("Added quote: " + quote);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    @Override
    public String getRandomQuote() {


        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.size());

        Quote randomQuote = quoteList.get(randomIndex);

        return randomQuote.toString();
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteList;
    }

    @Override
    public void addQuote(Quote quote) {
        quoteList.add(quote);
    }
}