package com.company.vehicle;

import com.sun.istack.internal.NotNull;

public class Coordinates {
    private long x;
    @NotNull
    private Long y;

    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }
}
