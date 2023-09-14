package com.wonjun.model;


import org.springframework.stereotype.Component;

@Component
public class NoticeboardDto {
    private int article_no;
    private String title;
    private String content;
    private String write_date;
    private String write_id;

    public int getArticle_no() {
        return article_no;
    }

    public void setArticle_no(int article_no) {
        this.article_no = article_no;
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

    public String getWrite_date() {
        return write_date;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }

    public String getWrite_id() {
        return write_id;
    }

    public void setWrite_id(String write_id) {
        this.write_id = write_id;
    }
}
