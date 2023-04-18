package com.example.haproslaunchapp;

public class MediaPost {

    String imageDir, postDate,postDesc;

    public MediaPost(String imageDir, String postDate, String postDesc) {
        this.imageDir = imageDir;
        this.postDate = postDate;
        this.postDesc = postDesc;
    }

    public String getImageDir() {
        return imageDir;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getPostDesc() {
        return postDesc;
    }
}
