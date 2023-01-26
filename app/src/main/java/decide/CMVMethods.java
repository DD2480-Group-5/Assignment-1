package decide;

import java.awt.Point;
import java.lang.Math;

public class CMVMethods {
    // Implement the methods for section 2.1 in this class

    /**
     * Returns true if there are at least two consecutive points
     * whose distance are greater then len.
     * 
     * @param points    : An array of planar points
     * @param length    : The distance being compared
     * @return          : A boolean indicating of the two points are within length of each other
     */
    public static boolean cmvMethod0(Point[] points, double length) {
        double point_distance;
        for (int i = 0; i < points.length - 1; i++) {
            point_distance = Math.sqrt(
                Math.pow(points[i].x - points[i+1].x,2) + 
                Math.pow(points[i].y - points[i+1].y,2)
            );

            if (point_distance > length) {
                return true;
            }
        }

        return false;
    }
}
