package com.company;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Message implements Serializable {

    @CsvBindByPosition(position = 0)
    private String message;

    @CsvBindByPosition(position = 1)
    private String number;

    public Message(String message, String number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", number=" + number +
                '}';
    }
}
