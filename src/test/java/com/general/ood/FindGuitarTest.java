package com.general.ood;

import com.general.ood.ricksapp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindGuitarTest {

    private Inventory inventory = new Inventory();

    @BeforeEach
    public void setUp() {
        /*EasyRandom generator = new EasyRandom();
        List<Guitar> guitars = generator.objects(Guitar.class, 30).collect(Collectors.toList());
        guitars.add(new Guitar(UUID.randomUUID().toString(), 1000, new GuitarSpec("Statocaster", Builder.FENDER,
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6)));
        Collections.shuffle(guitars);
        guitars.stream().forEach(g ->
                inventory.addGuitar(g.getSerialNumber(), g.getPrice(), g.getSpec().getModel(), g.getSpec().getBuilder(),
                        g.getSpec().getType(), g.getSpec().getBackWood(), g.getSpec().getTopWood(), g.getSpec().getNumStrings()));*/

        Map properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SPRUCE);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.MARTIN);
        properties.put("model", "D-18");
        properties.put("numStrings", 6);
        properties.put("type", Type.ACOUSTIC);
        properties.put("backWood", Wood.MAHOGANY);
        properties.put("topWood", Wood.ADIRON_DACK);
        inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "stratocaster");
        properties.put("numStrings", 6);
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "stratocaster");
        properties.put("numStrings", 6);
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "SG-16 Resissue");
        properties.put("numStrings", 6);
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.MAHOGANY);
        properties.put("topWood", Wood.MAHOGANY);
        inventory.addInstrument("82765501", 1890.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Les Paul");
        properties.put("numStrings", 6);
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        inventory.addInstrument("70108276", 2295.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "F5-G");
        properties.put("type", Type.ACOUSTIC);
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.BANJO);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "RB-3");
        properties.put("numStrings", 5);
        properties.put("type", Type.ACOUSTIC);
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));

    }

    @Test
    public void findGuitar() {
        /*GuitarSpec whatErikLikes = new GuitarSpec("Statocaster", Builder.FENDER,
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
        List<Guitar> guitars = inventory.search(whatErikLikes);
        for (Guitar guitar: guitars) {
            System.out.println("Erik might like : " + guitar.toString());
        }
        Assert.assertEquals(1, guitars.size());*/
        Map properties = new HashMap();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);
        InstrumentSpec spec = new InstrumentSpec(properties);
        List<Instrument> instruments = inventory.search(spec);

    }
}
