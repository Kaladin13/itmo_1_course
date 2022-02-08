package com.company.vechile.parts;

public class Coordinates {
    private long x;
    private Long y;

    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
