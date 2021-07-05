package com.general.ood;

import org.jeasy.random.EasyRandom;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class FindGuitarTest {

    private Inventory inventory = new Inventory();

    @BeforeEach
    public void setUp() {
        EasyRandom generator = new EasyRandom();
        List<Guitar> guitars = generator.objects(Guitar.class, 30).collect(Collectors.toList());
        guitars.add(new Guitar(UUID.randomUUID().toString(), 1000, "Statocaster", Builder.FENDER,
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        Collections.shuffle(guitars);
        guitars.stream().forEach(g ->
                inventory.addGuitar(g.getSerialNumber(), g.getPrice(), g.getSpec().getModel(), g.getSpec().getBuilder(),
                        g.getSpec().getType(), g.getSpec().getBackWood(), g.getSpec().getTopWood()));
    }

    @Test
    public void findGuitar() {
        GuitarSpec whatErikLikes = new GuitarSpec("Statocaster", Builder.FENDER,
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
        List<Guitar> guitars = inventory.search(whatErikLikes);
        for (Guitar guitar: guitars) {
            System.out.println("Erik might like : " + guitar.toString());
        }
        Assert.assertEquals(1, guitars.size());
    }
}
