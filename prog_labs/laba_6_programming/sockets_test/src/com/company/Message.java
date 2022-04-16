package com.company;

import java.io.Serializable;

public class Message implements Serializable {
    private String message;
    private Long number;

    public Message(String message, Long number) {
        this.message = message;
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
