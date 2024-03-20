package com.example.demo.service;

public class Quote {
    private Long id;
    private String content;
    private String author;
    private int length;
    String dateAdded;
    String dateModified;

    private String authorSlug;


private static Long nextId = 0L;

    public Quote(String id, String content, String author, String dateAdded, int length,  String dateModified, String authorSlug) {
        this.id = nextId++;
        this.content = content;
        this.author = author;
        this.length = length;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.authorSlug = authorSlug;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static Long getNextId() {
        return nextId++;
    }

    public static void setNextId(Long nextId) {
        Quote.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Quote of the day: {" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +

                '}';
    }
}
