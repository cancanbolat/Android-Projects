package com.example.learnsoftware.Model;

public class Posts {

    private String blog_id;
    private String blog_name;
    private String blog_detail;
    private String blog_small_detail;

    @Override
    public String toString() {
        return "Posts{" +
                "blog_id='" + blog_id + '\'' +
                ", blog_name='" + blog_name + '\'' +
                ", blog_detail='" + blog_detail + '\'' +
                ", blog_small_detail='" + blog_small_detail + '\'' +
                '}';
    }

    public String getBlog_small_detail() {
        return blog_small_detail;
    }

    public void setBlog_small_detail(String blog_small_detail) {
        this.blog_small_detail = blog_small_detail;
    }

    public String getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(String blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_name() {
        return blog_name;
    }

    public void setBlog_name(String blog_name) {
        this.blog_name = blog_name;
    }

    public String getBlog_detail() {
        return blog_detail;
    }

    public void setBlog_detail(String blog_detail) {
        this.blog_detail = blog_detail;
    }


}
