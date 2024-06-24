package org.example.javafx_demo.entity;

public class Article {
    private long id;
    private String title;
    private String description;
    private String content;

    public Article() {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Article(int id, String title, String description, String content) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}