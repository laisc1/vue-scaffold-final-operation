package com.laisc.finalwork_server.entity;

public class Article {
    private Integer id=0;
    private String title="";
    private String article="";

    public Article() {
    }

    public Article(Integer id, String title, String article) {
        this.id = id;
        this.title = title;
        this.article = article;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                '}';
    }
}
