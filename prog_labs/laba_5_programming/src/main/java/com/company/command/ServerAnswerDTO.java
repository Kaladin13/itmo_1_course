package com.company.command;

import java.io.Serializable;
import java.util.ArrayDeque;

public class ServerAnswerDTO implements Serializable {
    String answer;
    ArrayDeque<String> argument;

    public ServerAnswerDTO(String answer, ArrayDeque<String> argument) {
        this.answer = answer;
        this.argument = argument;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayDeque<String> getArgument() {
        return argument;
    }

    public ServerAnswerDTO(String answer) {
        this.answer = answer;
    }
}
