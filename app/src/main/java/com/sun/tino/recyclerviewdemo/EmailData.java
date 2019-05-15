package com.sun.tino.recyclerviewdemo;

public class EmailData {
    private String mTitle, mContent, mTime;
    private boolean mFavorite;

    public EmailData() {
    }

    public EmailData(String mTitle, String mContent, String mTime) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mTime = mTime;
        this.mFavorite = false;
    }

    public EmailData(String mTitle, String mContent, String mTime, boolean mFavorite) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mTime = mTime;
        this.mFavorite = mFavorite;
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public void setFavorite(boolean mFavorite) {
        this.mFavorite = mFavorite;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }
}
