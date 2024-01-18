package com.lingolift.lingoliftbackend.dto;


public class Choice {

    private int index;
    private String text;

    public Choice() {

    }

    public Choice(int index, String text) {
        this.index = index;
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setText(String text) {
        this.text = text;
    }
}
