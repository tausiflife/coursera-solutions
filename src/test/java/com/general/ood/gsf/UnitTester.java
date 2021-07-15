package com.general.ood.gsf;

import com.general.ood.gsf.unit.Unit;
import com.general.ood.gsf.unit.Weapon;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class UnitTester {
    Unit unit;

    @BeforeEach
    void setUp() {
        unit = new Unit(1);
        unit.setName("Damon");
    }

    @Test
    public void testType() {
        unit.setType("infantry");
        Assert.assertEquals("infantry", unit.getType());
    }

    @Test
    void testUnitSpecificProperty() {
        unit.setProperties("hitPoints", 25);
        Assert.assertEquals(25, (int) unit.getProperty("hitPoints"));
    }

    @Test
    void testIdProperty() {
        Assert.assertEquals(1, unit.getId());
    }

    @Test
    void testSettingNameProperty() {
        Assert.assertEquals("Damon", unit.getName());
    }

    @Test
    void testAddingWeapons() {
        Weapon weapon = new Weapon();
        unit.addWeapon(weapon);
        Assert.assertEquals(weapon, unit.getWeapons().get(0));
    }

    @Test
    void shouldThrowExceptionWhenElementDoesNotExist() {
        Throwable throwable = Assertions.assertThrows(NoSuchElementException.class, () -> unit.getProperty("speed"));
        Assert.assertEquals("No element exists with such name speed", throwable.getMessage());
    }

    @Nested
    class UnitTestExistingProperty {
        Unit unit;

        @BeforeEach
        void setUp() {
            unit = new Unit(1);
            unit.setProperties("hitPoints", 15);
        }

        @Test
        void testChangingExistingProperty() {
            unit.setProperties("hitPoints", 25);
            Assert.assertEquals(25, (int) unit.getProperty("hitPoints"));

        }

    }
}
