package com.company;

public enum Asw {
    A("111"),
    B("222");

    private final String name;

    Asw(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
