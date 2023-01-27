package decide;

import org.checkerframework.checker.units.qual.K;

import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.Math;

public class CMVMethods {
    // Implement the methods for section 2.1 in this class

    /**
     * Helper method for calculating the angle between the two lines formed by three points.
     *
     * @param p1 :  Point 1, this is the point the lines start from.
     * @param p2 :  Point 2, end point for line 1.
     * @param p3 :  Point 3, end point for line 2.
     * @return Angle in degrees.
     */
    public static double angleBetweenThreePoints(Point p1, Point p2, Point p3) {
        double x = p1.x;
        double y = p1.y;

        double slopeAx = p2.x - x;
        double slopeAy = p2.y - y;
        double slopeBx = p3.x - x;
        double slopeBy = p3.y - y;

        double d = (slopeAx * slopeBx + slopeAy * slopeBy) / Math.sqrt((slopeAx * slopeAx + slopeAy * slopeAy) * (slopeBx * slopeBx + slopeBy * slopeBy));

        if (d > 1.0) return 0.0;

        else if (d < -1.0) return Math.PI;


        return Math.toRadians(Math.acos(d));
    }

    /**
     * CMV condition check 0.
     * Condition 0: There exists at least one set of two consecutive data points that are a distance greater than
     * the LENGTH1.
     *
     * @param points  :  Array containing the coordinates of data points.
     * @param LENGTH1 : The length threshold, must >= 0.
     * @return true if condition 0 is satisfied, else false.
     */
    public boolean CMV_0(Point[] points, double LENGTH1) {
        double point_distance;
        for (int i = 0; i < points.length - 1; i++) {
            point_distance = Math.sqrt(Math.pow(points[i].x - points[i + 1].x, 2) + Math.pow(points[i].y - points[i + 1].y, 2));

            if (point_distance > LENGTH1) {
                return true;
            }
        }

        return false;
    }

    /**
     * CMV condition check 1.
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1.
     *
     * @param points  :  Array containing the coordinates of data points.
     * @param RADIUS1 : The radius threshold, must >= 0.
     * @return true if condition 1 is satisfied, else false.
     */
    public boolean CMV_1(Point[] points, double RADIUS1) {
        return false;
    }

    /**
     * CMV condition check 2.
     * There exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI−EPSILON)
     * or
     * angle > (PI+EPSILON)
     * The second of the three consecutive points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points.
     *
     * @param points  :  Array containing the coordinates of data points.
     * @param EPSILON : The angle threshold, 0 ≤ EPSILON < PI.
     * @return true if condition 2 is satisfied, else false.
     */
    public boolean CMV_2(Point[] points, double EPSILON) {
        if ((points.length < 3) || (Math.abs(EPSILON) > Math.PI)) return false;

        // Loop three points at a time
        Point p1, p2, p3;
        for (int i = 1; i < (points.length - 1); i++) {
            p1 = points[i - 1];
            p2 = points[i];
            p3 = points[i + 1];
            if (!(p2.equals(p1) && !(p2.equals(p3)))) {
                double angle = Math.abs(angleBetweenThreePoints(p2, p1, p3));
                if (angle > (Math.PI + EPSILON) || angle < (Math.PI - EPSILON)) return true;
            }
        }
        return false;
    }

    /**
     * CMV condition check 3.
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1.
     *
     * @param points : Array containing the coordinates of data points.
     * @param AREA1  :  The area threshold, 0 ≤ AREA1.
     * @return true if condition 3 is satisfied, else false.
     */
    public boolean CMV_3(Point[] points, double AREA1) {
        if (points.length < 3) return false;

        Point p1, p2, p3;
        for (int i = 0; i < (points.length) - 2; ++i) {
            p1 = points[i];
            p2 = points[i + 1];
            p3 = points[i + 2];

            if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) continue;

            double area = Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2);

            if (area > AREA1) return true;
        }
        return false;
    }

    /**
     * CMV condition check 4.
     * There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
     * quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     *
     * @param points : Array containing the coordinates of data points.
     * @param Q_PTS  :  2 ≤ Q_PTS ≤ NUMPOINTS.
     * @param QUADS  :  1 ≤ QUADS ≤ 3.
     * @return true if condition 4 is satisfied, else false.
     */
    public boolean CMV_4(Point[] points, int Q_PTS, int QUADS) {
        return false;
    }

    /**
     * CMV condition check 5.
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
     * that X[j] - X[i] < 0. (where i = j-1)
     *
     * @param points : Array containing the coordinates of data points.
     * @return true if condition 5 is satisfied, else false.
     */
    public boolean CMV_5(Point[] points) {
        return false;
    }

    /**
     * CMV condition check 6.
     * There exists at least one set of N PTS consecutive data points such that at least one of the
     * points lies a distance greater than DIST from the line joining the first and last of these N PTS
     * points. If the first and last points of these N PTS are identical, then the calculated distance
     * to compare with DIST will be the distance from the coincident point to all other points of
     * the N PTS consecutive points. The condition is not met when NUMPOINTS < 3.
     *
     * @param points : Array containing the coordinates of data points.
     * @param N_PTS  :  3 ≤ N_PTS ≤ NUMPOINTS
     * @param DIST   :   0 ≤ DIST
     * @return true if condition 6 is satisfied, else false.
     */
    public boolean CMV_6(Point[] points, int N_PTS, double DIST) {
        return false;
    }

    /**
     * CMV condition check 7.
     * There exists at least one set of two data points separated by exactly K_PTS consecutive intervening
     * points that are a distance greater than the length, LENGTH1, apart.
     * <p>
     * The condition is not met when NUMPOINTS < 3.
     *
     * @param points  :  Array containing the coordinates of data points.
     * @param K_PTS   :   1 ≤ K_PTS ≤ (NUMPOINTS−2)
     * @param LENGTH1 : The length threshold, LENGTH1 >= 0.
     * @return true if condition 7 is satisfied, else false.
     */
    public boolean CMV_7(Point[] points, int K_PTS, double LENGTH1) {
        int length = points.length;

        if (K_PTS < 1 || K_PTS + 2 > length) return false;

        if (LENGTH1 < 0) return false;

        if (length < 3) return false;

        for (int i = 0; i < length - K_PTS - 1; i++) {
            Point a = points[i];
            Point b = points[i + K_PTS + 1];

            double distance = calculateDistance(a, b);
            if (distance > LENGTH1) return true;
        }
        return false;
    }

    /**
     * CMV condition check 8.
     * There exists at least one set of three data points separated by exactly A PTS and B PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. The condition is not met when NUMPOINTS < 5.
     *
     * @param points  :  Array containing the coordinates of data points.
     * @param A_PTS   :   1 ≤ A_PTS, A_PTS+B_PTS ≤ (NUMPOINTS−3).
     * @param B_PTS   :   1 ≤ B_PTS, A_PTS+B_PTS ≤ (NUMPOINTS−3).
     * @param RADIUS1 : 0 ≤ RADIUS1.
     * @return true if condition 8 is satisfied, else false.
     */
    public boolean CMV_8(Point[] points, int A_PTS, int B_PTS, double RADIUS1) {
        int length = points.length;

        if (A_PTS < 1 || B_PTS < 1 || A_PTS + B_PTS + 3 > length) return false;

        if (length < 5) return false;

        if (RADIUS1 < 0) return false;

        for (int i = 0; i < length - A_PTS - B_PTS - 2; i++) {
            Point a = points[i];
            Point b = points[i + A_PTS + 1];
            Point c = points[i + A_PTS + 1 + B_PTS + 1];

            double r = calculateCentre(a, b, c);

            if (r <= RADIUS1) return false;
        }
        return true;
    }

    /**
     * CMV condition check 9.
     * There exists at least one set of three data points separated by exactly C PTS and D PTS
     * consecutive intervening points, respectively, that form an angle such that:
     * angle < (PI−EPSILON)
     * or
     * angle > (PI+EPSILON)
     * The second point of the set of three points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincide with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points. When NUMPOINTS < 5, the condition is not met.
     *
     * @param points  :  Array containing the coordinates of data points.
     * @param C_PTS   :   1 ≤ C_PTS, C_PTS+D_PTS ≤ (NUMPOINTS−3).
     * @param D_PTS   :   1 ≤ D_PTS, C_PTS+D_PTS ≤ (NUMPOINTS−3).
     * @param EPSILON : 0 ≤ EPSILON < PI.
     * @return true if condition 9 is satisfied, else false.
     */
    public boolean CMV_9(Point[] points, int C_PTS, int D_PTS, double EPSILON) {
        return false;
    }

    /**
     * CMV condition check 10.
     * There exists at least one set of three data points separated by exactly E PTS and F PTS consecutive
     * intervening points, respectively, that are the vertices of a triangle with area greater than AREA1.
     * The condition is not met when NUMPOINTS < 5.
     *
     * @param points : Array containing the coordinates of data points.
     * @param E_PTS  :  1 ≤ E_PTS, E_PTS+F_PTS ≤ (NUMPOINTS−3).
     * @param F_PTS  :  1 ≤ F_PTS, E_PTS+F_PTS ≤ (NUMPOINTS−3).
     * @param AREA1  :  0 ≤ AREA1.
     * @return true if condition 10 is satisfied, else false.
     */
    public boolean CMV_10(Point[] points, int E_PTS, int F_PTS, double AREA1) {
        return false;
    }

    /**
     * CMV condition check 11.
     * There exists at least one set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by
     * exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0. (where i < j ) The
     * condition is not met when NUMPOINTS < 3.
     *
     * @param points : Array containing the coordinates of data points.
     * @param G_PTS  :  1 ≤ G_PTS ≤ NUMPOINTS−2.
     * @return true if condition 11 is satisfied, else false.
     */
    public boolean CMV_11(Point[] points, int G_PTS) {
        int length = points.length;

        if (length < 3) return false;

        if (G_PTS < 1 || G_PTS + 2 > length) return false;

        for (int i = 0; i < length - G_PTS - 1; i++) {
            Point a = points[i];
            Point b = points[i + G_PTS + 1];

            if (b.x - a.x < 0) return true;
        }

        return false;
    }

    /**
     * CMV condition check 12.
     * There exists at least one set of two data points, separated by exactly K PTS consecutive
     * intervening points, which are a distance greater than the length, LENGTH1, apart. In addition,
     * there exists at least one set of two data points (which can be the same or different from
     * the two data points just mentioned), separated by exactly K PTS consecutive intervening
     * points, that are a distance less than the length, LENGTH2, apart. Both parts must be true
     * for the LIC to be true. The condition is not met when NUMPOINTS < 3.
     *
     * @param points  : Array containing the coordinates of data points.
     * @param K_PTS   :
     * @param LENGTH2 : 0 ≤ LENGTH2.
     * @return true if condition 12 is satisfied, else false.
     */
    public boolean CMV_12(Point[] points, int K_PTS, double LENGTH2) {
        return false;
    }

    /**
     * CMV condition check 13.
     * There exists at least one set of three data points, separated by exactly A PTS and B PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. In addition, there exists at least one set of three data points (which can be
     * the same or different from the three data points just mentioned) separated by exactly A PTS
     * and B PTS consecutive intervening points, respectively, that can be contained in or on a
     * circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is
     * not met when NUMPOINTS < 5.
     *
     * @param points  : Array containing the coordinates of data points.
     * @param A_PTS   :  1 ≤ A_PTS, A_PTS+B_PTS ≤ (NUMPOINTS−3).
     * @param B_PTS   :  1 ≤ B_PTS, A_PTS+B_PTS ≤ (NUMPOINTS−3).
     * @param RADIUS1 : 0 ≤ RADIUS1
     * @param RADIUS2 : 0 ≤ RADIUS2
     * @return true if condition 13 is satisfied, else false.
     */
    public boolean CMV_13(Point[] points, int A_PTS, int B_PTS, double RADIUS1, double RADIUS2) {
        return false;
    }

    /**
     * CMV condition check 14.
     * There exists at least one set of three data points, separated by exactly E PTS and F PTS consecutive
     * intervening points, respectively, that are the vertices of a triangle with area greater than AREA1.
     * In addition, there exist three data points (which can be the same or different from the three data
     * points just mentioned) separated by exactly E PTS and F PTS consecutive intervening points,
     * respectively, that are the vertices of a triangle with area less than AREA2. Both parts must be true
     * for the LIC to be true. The condition is not met when NUMPOINTS < 5.
     *
     * @param points : Array containing the coordinates of data points.
     * @param E_PTS  :  1 ≤ E_PTS, E_PTS+F_PTS ≤ (NUMPOINTS−3).
     * @param F_PTS  :  1 ≤ F_PTS, E_PTS+F_PTS ≤ (NUMPOINTS−3).
     * @param AREA1  :  0 ≤ AREA1.
     * @param AREA2  :  0 ≤ AREA2.
     * @return true if condition 14 is satisfied, else false.
     */
    public boolean CMV_14(Point[] points, int E_PTS, int F_PTS, double AREA1, double AREA2) {
        return false;
    }

    /**
     * Calculate the distance between 2 points.
     *
     * @param a : point a.
     * @param b : point b.
     * @return the distance between a and b.
     */
    private static double calculateDistance(Point a, Point b) {
        double x = Math.abs(a.x - b.x);
        double y = Math.abs(a.y - b.y);
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * Find the center of a circle based on three points.
     *
     * @param a : point a.
     * @param b : point b.
     * @param c : point c.
     * @return the circle radius.
     */
    private static double calculateCentre(Point a, Point b, Point c) {
        double yDelta_a = b.y - a.y;
        double xDelta_a = b.x - a.x;
        double yDelta_b = c.y - b.y;
        double xDelta_b = c.x - b.x;
        double center_x, center_y;

        double aSlope = yDelta_a / xDelta_a;
        double bSlope = yDelta_b / xDelta_b;

        Point2D abMid = new Point2D.Double((double) (a.x + b.x) / 2, (double) (a.y + b.y) / 2);
        Point2D bcMid = new Point2D.Double((double) (b.x + c.x) / 2, (double) (b.y + c.y) / 2);

        if (yDelta_a == 0)         //aSlope == 0
        {
            center_x = abMid.getX();
            if (xDelta_b == 0)         //bSlope == INFINITY
            {
                center_y = bcMid.getY();
            } else {
                center_y = bcMid.getY() + (bcMid.getX() - center_x) / bSlope;
            }
        } else if (yDelta_b == 0)               //bSlope == 0
        {
            center_x = bcMid.getX();
            if (xDelta_a == 0)             //aSlope == INFINITY
            {
                center_y = abMid.getY();
            } else {
                center_y = abMid.getY() + (abMid.getX() - center_x) / aSlope;
            }
        } else if (xDelta_a == 0)        //aSlope == INFINITY
        {
            center_y = abMid.getY();
            center_x = bSlope * (bcMid.getY() - center_y) + bcMid.getX();
        } else if (xDelta_b == 0)        //bSlope == INFINITY
        {
            center_y = bcMid.getY();
            center_x = aSlope * (abMid.getY() - center_y) + abMid.getX();
        } else {
            center_x = (aSlope * bSlope * (abMid.getY() - bcMid.getY()) - aSlope * bcMid.getX()
                    + bSlope * abMid.getX()) / (bSlope - aSlope);
            center_y = abMid.getY() - (center_x - abMid.getX()) / aSlope;
        }

        double x = Math.abs(center_x - b.x);
        double y = Math.abs(center_y - b.y);

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
