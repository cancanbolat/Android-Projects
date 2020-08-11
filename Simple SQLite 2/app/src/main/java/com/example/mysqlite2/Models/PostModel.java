package com.example.mysqlite2.Models;

public class PostModel {
    String post_id, post_title, post_image, post_detail,
            post_added_time, post_up_time;

    public PostModel(String post_id, String post_title, String post_image, String post_detail, String post_added_time, String post_up_time) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_image = post_image;
        this.post_detail = post_detail;
        this.post_added_time = post_added_time;
        this.post_up_time = post_up_time;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getPost_detail() {
        return post_detail;
    }

    public void setPost_detail(String post_detail) {
        this.post_detail = post_detail;
    }

    public String getPost_added_time() {
        return post_added_time;
    }

    public void setPost_added_time(String post_added_time) {
        this.post_added_time = post_added_time;
    }

    public String getPost_up_time() {
        return post_up_time;
    }

    public void setPost_up_time(String post_up_time) {
        this.post_up_time = post_up_time;
    }
}
