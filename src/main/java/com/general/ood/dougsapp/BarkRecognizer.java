package com.general.ood.dougsapp;

import java.util.Optional;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("Bark recognizer heard a " + bark);
        Optional<Bark> optionalBark = door.getAllowedBark().stream().filter(e -> e.equals(bark)).findFirst();
        if (optionalBark.isPresent())
            door.open();
        else
            System.out.println("This dog is not allowed.");
    }
}
