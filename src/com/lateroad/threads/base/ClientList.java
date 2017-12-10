package com.lateroad.threads.base;

import com.lateroad.threads.entity.Client;

import java.util.ArrayDeque;

public class ClientList {
    private static ArrayDeque<Client> clients = new ArrayDeque<>();

    public static void add(Client client) {
        clients.add(client);
    }

    public static Client get() {
        return clients.poll();
    }

    public static int size() {
        return clients.size();
    }
}
