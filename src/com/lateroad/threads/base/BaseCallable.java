package com.lateroad.threads.base;

import com.lateroad.threads.entity.Client;
import com.lateroad.threads.entity.Location;
import com.lateroad.threads.entity.Taxi;
import com.lateroad.threads.singleton.TaxiPark;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BaseCallable implements Callable<String> {
    private static final Logger LOGGER = Logger.getLogger(BaseCallable.class);

    static {
        new DOMConfigurator().doConfigure("log4j2.xml", LogManager.getLoggerRepository());
    }

    @Override
    public String call() {
        Client client = ClientList.get();
        LOGGER.info(client.getName() + ". His location is " + client.getLocation() + ". His aim is " + client.getAim() + ".");
        String result = "";
        try {
            Taxi taxi = TaxiPark.getInstance().getTaxi(client);
            LOGGER.info(client.getName() + ". Taxi is " + taxi.getNumber() + ". Its location is " + taxi.getLocation() + ".");
            Location aim = client.getAim();
            int time = (int) TaxiPark.getInstance().calculateTime(client, taxi);
            LOGGER.info(client.getName() + ". Time to aim is " + time + ".");
            TimeUnit.MILLISECONDS.sleep(time);
            LOGGER.info(client.getName() + ". Time has passed.");
            client.setLocation(aim);
            LOGGER.info(client.getName() + ". His location is " + client.getLocation() + ". His aim is " + client.getAim() + ".");
            taxi.setLocation(aim);
            LOGGER.info(client.getName() + ". Taxi for is " + taxi.getNumber() + ". Its location is " + taxi.getLocation() + ".");
            result = "" + client + taxi;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
