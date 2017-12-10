package com.lateroad.threads.base;

import com.lateroad.threads.entity.Client;
import com.lateroad.threads.singleton.TaxiPark;

import java.util.concurrent.Callable;

public class BaseCallable implements Callable<String> {

    @Override
    public String call(){

        Client client = ClientList.get();
        String result;
        if(client != null){
            result = client.getName() + TaxiPark.getInstance().getTaxi(client);
        } else {
            result = "ClientList is empty";
        }
        System.out.println(result);
        return result;
    }
}
