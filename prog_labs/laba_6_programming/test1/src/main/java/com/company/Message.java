package com.company;

import java.io.Serializable;

public class Message implements Serializable {
    private int num;
    private String mm;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    @Override
    public String toString() {
        return "Message{" +
                "num=" + num +
                ", mm='" + mm + '\'' +
                '}';
    }

    public Message(int num, String mm) {
        this.num = num;
        this.mm = mm;
    }
}
