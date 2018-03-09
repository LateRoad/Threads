package com.lateroad.threads.entity;

import java.util.Objects;

public class Client {
    private String name;
    private Location location;
    private Location aim;

    public Client() {
        this.name = "Undefined client";
        this.location = new Location();
        this.aim = new Location();
    }

    public Client(String name) {
        this.name = name;
        this.location = new Location();
        this.aim = new Location();
    }

    public Client(String name, Location location) {
        this.name = name;
        this.location = location;
        this.aim = new Location();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getAim() {
        return aim;
    }

    public void setAim(Location aim) {
        this.aim = aim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(location, client.location) &&
                Objects.equals(aim, client.aim);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, location, aim);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", aim=" + aim +
                '}';
    }
}
