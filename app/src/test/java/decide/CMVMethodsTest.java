package decide;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

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
        Point2D[] points = {new Point2D.Double(-2, -2), new Point2D.Double(0, 0), new Point2D.Double(2, 2)};
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

    @Test
    void testPositiveCmv6() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(1, 0),
                new Point2D.Double(2, 0),
                new Point2D.Double(3, 3),
                new Point2D.Double(4, 2)
        };
        int n_pts = 4;
        double dist = 1;
        boolean b = CMVMethods.CMV_6(points, n_pts, dist);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv6() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2)
        };
        int n_pts = 5;
        double dist = 2;
        boolean b = CMVMethods.CMV_6(points, n_pts, dist);
        assertFalse(b);
    }

    @Test
    void testPositiveCmv7() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 3),
                new Point2D.Double(-1, 0),
                new Point2D.Double(1, 0),
                new Point2D.Double(0, 1),
                new Point2D.Double(4, 0),
        };
        int k_pts = 3;
        double length1 = 4.8;
        assertTrue(CMVMethods.CMV_7(points, k_pts, length1));
    }

    @Test
    void testNegativeCmv7() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 3),
                new Point2D.Double(-1, 0),
                new Point2D.Double(1, 0),
                new Point2D.Double(0, 1),
                new Point2D.Double(4, 0),
        };
        int k_pts = 3;
        int k_pts_2 = 6;
        double length1 = 5;
        double length2 = -1;
        assertFalse(CMVMethods.CMV_7(points, k_pts, length1));
        assertFalse(CMVMethods.CMV_7(points, k_pts_2, length1));
        assertFalse(CMVMethods.CMV_7(points, k_pts, length2));
    }

    @Test
    void testPositiveCmv8() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(0, -2),
                new Point2D.Double(2, 0),
                new Point2D.Double(-2, 0),
                new Point2D.Double(0, 1),
                new Point2D.Double(4, 0),
        };
        int a_pts = 1, b_pts = 1;
        double radius2 = 2;
        assertTrue(CMVMethods.CMV_8(points, a_pts, b_pts, radius2));
    }

    @Test
    void testNegativeCmv8() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(0, -2),
                new Point2D.Double(2, 0),
                new Point2D.Double(-2, 0),
                new Point2D.Double(0, 1),
                new Point2D.Double(1, 0),
        };
        int a_pts = 1, b_pts = 1;
        int a_pts_f = 5;
        double radius2 = 2;
        double radius2_f = -2;
        assertFalse(CMVMethods.CMV_8(points, a_pts, b_pts, radius2));
        assertFalse(CMVMethods.CMV_8(points, a_pts_f, b_pts, radius2));
        assertFalse(CMVMethods.CMV_8(points, a_pts, b_pts, radius2_f));
    }

    @Test
    void testPositiveCmv9() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(1, 1),
                new Point2D.Double(0, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(2, 0)
        };
        int c_pts = 1;
        int d_pts = 1;
        double epsilon = 0.1 * Math.PI;
        boolean b = CMVMethods.CMV_9(points, c_pts, d_pts, epsilon);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv9() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2)
        };
        int c_pts = 1;
        int d_pts = 4;
        double epsilon = 0.2;
        boolean b = CMVMethods.CMV_9(points, c_pts, d_pts, epsilon);
        assertFalse(b);
    }

    @Test
    void testPositiveCmv10() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(1, 1),
                new Point2D.Double(0, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(2, 0)
        };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = 1;
        boolean b = CMVMethods.CMV_10(points, e_pts, f_pts, area1);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv10() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2)
        };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = -1;
        boolean b = CMVMethods.CMV_10(points, e_pts, f_pts, area1);
        assertFalse(b);
    }

    @Test
    void testPositiveCmv11() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(-1, 0)
        };
        int g_pts = 2;
        assertTrue(CMVMethods.CMV_11(points, g_pts));
    }

    @Test
    void testNegativeCmv11() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(-1, 0)
        };
        Point2D[] points_2 = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(2, 0)
        };
        Point2D[] points_3 = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2)
        };
        int g_pts = 2;
        int g_pts_f = 5;
        assertFalse(CMVMethods.CMV_11(points, g_pts_f));
        assertFalse(CMVMethods.CMV_11(points_2, g_pts));
        assertFalse(CMVMethods.CMV_11(points_3, g_pts));
    }

    @Test
    void testPositiveCmv13() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(1, 1),
                new Point2D.Double(0, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(2, 0),
                new Point2D.Double(3, 1)
        };
        int a_pts = 1;
        int b_pts = 1;
        double radius1 = 1;
        double radius2 = 2;
        boolean b = CMVMethods.CMV_13(points, a_pts, b_pts, radius1, radius2);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv13() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2)
        };
        int a_pts = 1;
        int b_pts = 1;
        double radius1 = 1;
        double radius2 = 1;
        boolean b = CMVMethods.CMV_13(points, a_pts, b_pts, radius1, radius2);
        assertFalse(b);
    }

    @Test
    void testPositiveCmv14() {
        Point2D[] points = {
                new Point2D.Double(0, 2),
                new Point2D.Double(1, 1),
                new Point2D.Double(0, 0),
                new Point2D.Double(2, 2),
                new Point2D.Double(2, 0),
                new Point2D.Double(3, 1)
        };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = 1;
        double area2 = 2;
        boolean b = CMVMethods.CMV_14(points, e_pts, f_pts, area1, area2);
        assertTrue(b);
    }

    @Test
    void testNegativeCmv14() {
        Point2D[] points = {
                new Point2D.Double(0, 0),
                new Point2D.Double(0, 2),
                new Point2D.Double(-2, 0),
                new Point2D.Double(2, 2)
        };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = -1;
        double area2 = 2;
        boolean b = CMVMethods.CMV_14(points, e_pts, f_pts, area1, area2);
        assertFalse(b);
    }
}