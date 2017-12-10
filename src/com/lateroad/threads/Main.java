package com.lateroad.threads;

import com.lateroad.threads.base.ClientList;
import com.lateroad.threads.entity.Client;
import com.lateroad.threads.executor.ClientExecutor;

public class Main {
    public static void main(String[] args) {
        ClientList clients = new ClientList();
        clients.add(new Client("Kolya"));
        clients.add(new Client("Masha"));
        clients.add(new Client("Nadya"));
        clients.add(new Client("Yan"));
        clients.add(new Client("Roma"));

        ClientExecutor executor = new ClientExecutor();
        executor.execute(clients);
    }
}
