package com.lateroad.threads.entity;

public class Taxi {
    private String number;
    private Location location;

    public Taxi() {
        this.number = "Undefined";
        this.location = new Location();
    }

    public Taxi(Location location) {
        this.number = "Undefined";
        this.location = location;
    }

    public Taxi(String number) {
        this.number = number;
        this.location = new Location();
    }

    public Taxi(String number, Location location) {
        this.number = number;
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Taxi taxi = (Taxi) o;

        if (!number.equals(taxi.number)) return false;
        return location.equals(taxi.location);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 42 * result + location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "number='" + number + '\'' +
                ", location=" + location +
                '}';
    }
}
