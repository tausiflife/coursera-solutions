package com.general.problems;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CharlieJewelleryTest {

    @Test
    public void testCharlieJewellery() {
        CharlieJewellery charlieJewellery = new CharlieJewellery();
        Assert.assertEquals(5, charlieJewellery.calculateNumberOfNecklace(2, 8,9));
        Assert.assertEquals(34, charlieJewellery.calculateNumberOfNecklace(3, 6,9));
    }
}
