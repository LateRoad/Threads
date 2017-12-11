package com.lateroad.threads.singleton;

import com.lateroad.threads.entity.Client;
import com.lateroad.threads.entity.Location;
import com.lateroad.threads.entity.Taxi;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TaxiPark {
    private static TaxiPark instance = null;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static ArrayList<Taxi> freeTaxis = new ArrayList<>();
    private static ArrayList<Taxi> busyTaxis = new ArrayList<>();

    private TaxiPark() {
        freeTaxis.add(new Taxi("1234-7"));
        freeTaxis.add(new Taxi("1111-7"));
        freeTaxis.add(new Taxi("0000-7"));
        freeTaxis.add(new Taxi("2222-7"));
        freeTaxis.add(new Taxi("3333-7"));
        freeTaxis.add(new Taxi("4444-7"));
        freeTaxis.add(new Taxi("5555-7"));
    }

    public static TaxiPark getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new TaxiPark();
                    instanceCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Taxi getTaxi(Client client) {
        lock.lock();
        if (freeTaxis.isEmpty()) {
            lock.unlock();
            return null;
        }
        Location closest = new Location(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Taxi closestTaxi = new Taxi(closest);
        for (Taxi freeTaxi : freeTaxis) {
            if (calculatePath(client, closestTaxi) > calculatePath(client, freeTaxi)){
                closestTaxi = freeTaxi;
            }
        }
        freeTaxis.remove(closestTaxi);
        busyTaxis.add(closestTaxi);
        lock.unlock();
        return closestTaxi;
    }

    private double calculatePath(Client client, Taxi taxi) {
        return Math.hypot(
                client.getLocation().getX() - taxi.getLocation().getX(),
                client.getLocation().getY() - taxi.getLocation().getY());
    }

    public double calculateTime(Client client, Taxi taxi) {
        return calculatePath(client, taxi) * 100;
    }
}
