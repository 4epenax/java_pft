package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.old.Point;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(2,2);
        Point p2 = new Point(4,2);

        Assert.assertEquals(p1.distance(p2), 2);
    }
}