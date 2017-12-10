package com.lateroad.threads.entity;

public class Client {
    private String name;
    private Location location;

    public Client() {
        this.name = "Undefined client";
        this.location = new Location();
    }

    public Client(String name) {
        this.name = name;
        this.location = new Location();
    }

    public Client(String name, Location location) {
        this.name = name;
        this.location = location;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!name.equals(client.name)) return false;
        return location.equals(client.location);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
