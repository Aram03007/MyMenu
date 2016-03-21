package com.example.narek.mymenu;

/**
 * Created by Narek on 3/21/16.
 */
public class Data {
    private String title;
    private boolean hidden;
    private boolean cheked;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    private boolean color;

    public Data(String title, boolean hidden, boolean cheked, boolean color) {
        this.color = color;
        this.title = title;
        this.hidden = hidden;
        this.cheked = cheked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isCheked() {
        return cheked;
    }

    public void setCheked(boolean cheked) {
        this.cheked = cheked;
    }
}
