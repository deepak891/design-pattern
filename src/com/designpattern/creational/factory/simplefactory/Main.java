package com.designpattern.creational.factory.simplefactory;

import java.time.LocalDateTime;

/**
 * What problem does simple factory solve?
 *      - Multiple type can be instantiated and the choice is based on simple criteria
 * What is simple factory?
 *      - Here we move the instantiation logic to a separate class and most commonly to a static method of this class.
 *      - Some does not consider it as design pattern, as it's simply a method that encapsulate object creation
 */
public class Main {
    public static void main(String[] args) {
        Post post = PostFactory.createPost("news");
        System.out.println(post);
    }
}

class PostFactory{

    public static Post createPost(String type){
        switch (type) {
            case "blog" :
                return new BlogPost();
            case "news":
                return new NewsPost();
            case "product":
                return new ProductPost();
                default:
                     throw new IllegalArgumentException("Post type is unknown");
        }
    }
}

abstract class Post {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime publishedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDateTime publishedOn) {
        this.publishedOn = publishedOn;
    }
}

class BlogPost extends Post {
    private String author;
    private String[] tags;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}

class ProductPost extends Post {
    private String imageUrl;
    private String name;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class NewsPost extends Post {
    private String headline;
    private LocalDateTime newsTime;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public LocalDateTime getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(LocalDateTime newsTime) {
        this.newsTime = newsTime;
    }
}
