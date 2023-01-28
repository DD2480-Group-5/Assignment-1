package decide;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.lang.Math;
import java.awt.Point;

public class CMVMethodsTest {
    
    @Test
    void testPositiveCmv0() {
        Point2D[] points = {new Point2D.Double(0, 0), new Point2D.Double(10, 10)};
        double len = 5.0;
        boolean b = CMVMethods.CMV_0(points, len);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv0() {
        Point2D[] points = {new Point2D.Double(0, 0), new Point2D.Double(2, 2), new Point2D.Double(-2, -2)};
        double len = 5.0;
        boolean b = CMVMethods.CMV_0(points, len);
        assertFalse(b);
    }

    @Test
    void testPositiveCmv1() {
        Point2D[] points = {
            new Point2D.Double(0, 0), 
            new Point2D.Double(0, 2), 
            new Point2D.Double(2, 0),
            new Point2D.Double(2, 2)
        };
        double radius = 1;
        boolean b = CMVMethods.CMV_1(points, radius);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv1() {
        Point2D[] points = {new Point2D.Double(0, 0), new Point2D.Double(2, 2)};
        double radius = 5;
        boolean b = CMVMethods.CMV_1(points, radius);
        assertFalse(b);
    }

    @Test
    void testPositiveCmv5() {
        Point2D[] points = {
            new Point2D.Double(0, 0), 
            new Point2D.Double(0, 2), 
            new Point2D.Double(-2, 0),
            new Point2D.Double(2, 2)
        };
        boolean b = CMVMethods.CMV_5(points);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv5() {
        Point2D[] points = {new Point2D.Double(0, 0)};
        boolean b = CMVMethods.CMV_5(points);
        assertFalse(b);
    }

}