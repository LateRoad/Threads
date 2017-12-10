package com.lateroad.threads.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Location {
    private int x;
    private int y;

    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 100;

    public Location() {
        this.x = ThreadLocalRandom.current().nextInt(MIN_COORDINATE, MAX_COORDINATE + 1);
        this.y = ThreadLocalRandom.current().nextInt(MIN_COORDINATE, MAX_COORDINATE + 1);
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
