package com.company.command;

public enum AuthorisationAnswers {
    SUCCESS("You have been authorised"),
    FAIL("There is no user with such login and password");

    private final String answer;

    AuthorisationAnswers(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return this.answer;
    }
}
