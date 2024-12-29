package org.example.entity;

import java.time.LocalDate;

public class Article {
    private long id;
    private String title;
    private String brief;
    private String content;
    private LocalDate createDate;
    private boolean isPublished;
    private LocalDate lastUpdateTime;
    private LocalDate publishDate;
}
