package decide;

import java.awt.*;

public class CMVMethods {
    // Implement the methods for section 2.1 in this class

    /**
     * CMV condition check 0.
     * Condition 0: There exists at least one set of two consecutive data points that are a distance greater than
     * the LENGTH1.
     *
     * @param points:  Array containing the coordinates of data points.
     * @param LENGTH1: The length threshold, must >= 0.
     * @return true if condition 0 is satisfied, else false.
     */
    public boolean CMV_0(Point[] points, double LENGTH1) {
        return false;
    }

    /**
     * CMV condition check 1.
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1.
     *
     * @param points:  Array containing the coordinates of data points.
     * @param RADIUS1: The radius threshold, must >= 0.
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
     * @param points:  Array containing the coordinates of data points.
     * @param EPSILON: The angle threshold. 0 ≤ EPSILON < PI.
     * @return true if condition 2 is satisfied, else false.
     */
    public boolean CMV_2(Point[] points, double EPSILON) {
        return false;
    }

    /**
     * CMV condition check 3.
     *
     * @return true if condition 3 is satisfied, else false.
     */
    public boolean CMV_3() {
        return false;
    }

    /**
     * CMV condition check 4.
     *
     * @return true if condition 4 is satisfied, else false.
     */
    public boolean CMV_4() {
        return false;
    }

    /**
     * CMV condition check 5.
     *
     * @return true if condition 5 is satisfied, else false.
     */
    public boolean CMV_5() {
        return false;
    }

    /**
     * CMV condition check 6.
     *
     * @return true if condition 6 is satisfied, else false.
     */
    public boolean CMV_6() {
        return false;
    }

    /**
     * CMV condition check 7.
     *
     * @return true if condition 7 is satisfied, else false.
     */
    public boolean CMV_7() {
        return false;
    }

    /**
     * CMV condition check 8.
     *
     * @return true if condition 8 is satisfied, else false.
     */
    public boolean CMV_8() {
        return false;
    }

    /**
     * CMV condition check 9.
     *
     * @return true if condition 9 is satisfied, else false.
     */
    public boolean CMV_9() {
        return false;
    }

    /**
     * CMV condition check 10.
     *
     * @return true if condition 10 is satisfied, else false.
     */
    public boolean CMV_10() {
        return false;
    }

    /**
     * CMV condition check 11.
     *
     * @return true if condition 11 is satisfied, else false.
     */
    public boolean CMV_11() {
        return false;
    }

    /**
     * CMV condition check 12.
     *
     * @return true if condition 12 is satisfied, else false.
     */
    public boolean CMV_12() {
        return false;
    }

    /**
     * CMV condition check 13.
     *
     * @return true if condition 13 is satisfied, else false.
     */
    public boolean CMV_13() {
        return false;
    }

    /**
     * CMV condition check 14.
     *
     * @return true if condition 14 is satisfied, else false.
     */
    public boolean CMV_14() {
        return false;
    }
}
