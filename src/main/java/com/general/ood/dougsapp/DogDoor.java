package com.general.ood.dougsapp;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private boolean open;
    private Bark bark;

    public DogDoor() {
        this.open = false;
    }

    public void open(){
        System.out.println("The dog door opens.");
        this.open = true;
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        }, 5000);
    }

    public void close() {
        System.out.println("The dog door closes.");
        this.open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public Bark getAllowedBark() {
        return bark;
    }

    public void setAllowedBark(Bark bark) {
        this.bark = bark;
    }
}
