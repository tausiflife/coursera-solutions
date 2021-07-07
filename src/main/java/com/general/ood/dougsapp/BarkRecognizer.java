package com.general.ood.dougsapp;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("Bark recognizer heard a " + bark);
        if (door.getAllowedBark().equals(bark))
            door.open();
        else
            System.out.println("This dog is not allowed.");
    }
}
