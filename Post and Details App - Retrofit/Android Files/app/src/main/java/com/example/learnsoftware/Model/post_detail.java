package com.example.learnsoftware.Model;

public class post_detail {
    private String detail;
    private String title;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "post_detail{" +
                "detail='" + detail + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
