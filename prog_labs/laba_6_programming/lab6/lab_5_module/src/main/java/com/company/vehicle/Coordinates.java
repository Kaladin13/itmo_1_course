package com.company.vehicle;


import java.io.Serializable;

public class Coordinates implements Serializable {
    private long x;
    private Long y;

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }
}
