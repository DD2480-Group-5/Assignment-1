package decide;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;
import java.lang.Math;
import java.awt.Point;

public class CMVMethodsTest {
    
    @Test
    void testPositiveCmv0() {
        Point[] points = {new Point(0, 0), new Point(10, 10)};
        double len = 5.0;
        boolean b = CMVMethods.CMV_0(points, len);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv0() {
        Point[] points = {new Point(0, 0), new Point(2, 2), new Point(-2, -2)};
        double len = 5.0;
        boolean b = CMVMethods.CMV_0(points, len);
        assertFalse(b);
    }
}
