package com.lateroad.threads;

import com.lateroad.threads.base.ClientList;
import com.lateroad.threads.entity.Client;
import com.lateroad.threads.executor.ClientExecutor;

public class Main {
    public static void main(String[] args) {
        ClientList.add(new Client("Kolya"));
        ClientList.add(new Client("Masha"));
        ClientList.add(new Client("Nadya"));
        ClientList.add(new Client("Yan"));
        ClientList.add(new Client("Roma"));

        ClientExecutor executor = new ClientExecutor();
        executor.execute();
    }
}
