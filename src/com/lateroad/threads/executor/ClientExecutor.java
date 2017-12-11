package com.lateroad.threads.executor;

import com.lateroad.threads.base.BaseCallable;
import com.lateroad.threads.base.ClientList;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientExecutor {
    public void execute() {
        final int poolSize = ClientList.size();
        ExecutorService es = Executors.newFixedThreadPool(poolSize);
        ArrayList<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < poolSize; ++i) {
            list.add(es.submit(new BaseCallable()));
        }
        for (Future<String> future : list) {
            try {
                System.out.println(future.get() + " result fixed");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
    }
}
