package com.general.ood;

import com.general.ood.dougsapp.Bark;
import com.general.ood.dougsapp.BarkRecognizer;
import com.general.ood.dougsapp.DogDoor;
import com.general.ood.dougsapp.Remote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogDoorSimulator {

    @Test
    public void testDogDoor() throws InterruptedException {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        System.out.println("Fido barks to go outside");
        remote.pressButton();
        Assertions.assertTrue(remote.getDoor().isOpen());
        System.out.println("Fido has gone outside");
        Assertions.assertTrue(remote.getDoor().isOpen());
        Thread.sleep(6000);
        System.out.println("Fido's all done'");
        Assertions.assertFalse(remote.getDoor().isOpen());
        System.out.println("... but he is stuck outside");
        System.out.println("Fido starts barking...");
        System.out.println("... so Tina grabs the remote control");
        remote.pressButton();
        System.out.println("Fido's back inside");
        Thread.sleep(6000);
        Assertions.assertFalse(remote.getDoor().isOpen());
    }

    @Test
    public void testBarkRecognizer() throws InterruptedException {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("rowlf"));
        door.addAllowedBark(new Bark("rooowIf"));
        door.addAllowedBark(new Bark("rawIf"));
        door.addAllowedBark(new Bark("woof"));
        BarkRecognizer barkRecognizer = new BarkRecognizer(door);
        //Simulate the hardware hearing a bark of bruce
        barkRecognizer.recognize(new Bark("rowlf"));
        System.out.println("Fido has gone outside...");
        Thread.sleep(10000);
        System.out.println("Fido is all done...");
        Assertions.assertFalse(door.isOpen());
        System.out.println("... but he is stuck outside");
        //simulate hardware hearing a bark again
        System.out.println("A small dog starts barking ");
        barkRecognizer.recognize(new Bark("yip"));
        Assertions.assertFalse(door.isOpen());
        System.out.println("Fido barks now...");
        barkRecognizer.recognize(new Bark("rooowIf"));
        Assertions.assertTrue(door.isOpen());
        System.out.println("Fido is back inside...");

    }
}
