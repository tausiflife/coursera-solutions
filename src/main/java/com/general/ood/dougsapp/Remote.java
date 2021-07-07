package com.general.ood.dougsapp;

import java.util.Timer;
import java.util.TimerTask;

public class Remote {

    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public DogDoor getDoor() {
        return door;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (door.isOpen())
            door.close();
        else {
            door.open();
        }
    }
}
