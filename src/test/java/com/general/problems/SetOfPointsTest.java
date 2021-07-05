package com.general.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SetOfPointsTest {
    private SetOfPoints setOfPoints = new SetOfPoints();

    @Test
    public void testSetOfPoints() {
        int minPoints = setOfPoints.findMinimumNumberOfPoints(3, new int[][]{{1, 3}, {2, 5}, {3, 6}});
        Assertions.assertEquals(1, minPoints);
    }

    @Test
    public void testSetOfPointsWithEqualCorinates() {
        int minPoints = setOfPoints.findMinimumNumberOfPoints(3, new int[][]{{1, 3}, {2, 5}, {2,4}});
        Assertions.assertEquals(1, minPoints);
    }
}
