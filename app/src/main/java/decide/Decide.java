package decide;

import static java.lang.Math.PI;
import java.awt.geom.Point2D;

public class Decide {

    private double LENGTH1;
    private double RADIUS1;
    private double EPSILON;
    private double AREA1;
    private int Q_PTS;
    private int QUADS;
    private double DIST;
    private int N_PTS;
    private int K_PTS;
    private int A_PTS;
    private int B_PTS;
    private int C_PTS;
    private int D_PTS;
    private int E_PTS;
    private int F_PTS;
    private int G_PTS;
    private double LENGTH2;
    private double RADIUS2;
    private double AREA2;
    private Point2D[] points;
    private Connector[][] LCM;
    private boolean[][] PUV;

    Decide(double LENGTH1,
            double RADIUS1,
            double EPSILON,
            double AREA1,
            int Q_PTS,
            int QUADS,
            double DIST,
            int N_PTS,
            int K_PTS,
            int A_PTS,
            int B_PTS,
            int C_PTS,
            int D_PTS,
            int E_PTS,
            int F_PTS,
            int G_PTS,
            double LENGTH2,
            double RADIUS2,
            double AREA2,
            Point2D[] points,
            Connector[][] LCM,
            boolean[][] PUV) {
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.EPSILON = EPSILON;
        this.AREA1 = AREA1;
        this.Q_PTS = Q_PTS;
        this.QUADS = QUADS;
        this.DIST = DIST;
        this.N_PTS = N_PTS;
        this.K_PTS = K_PTS;
        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.C_PTS = C_PTS;
        this.D_PTS = D_PTS;
        this.E_PTS = E_PTS;
        this.F_PTS = F_PTS;
        this.G_PTS = G_PTS;
        this.LENGTH2 = LENGTH2;
        this.RADIUS2 = RADIUS2;
        this.AREA2 = AREA2;
        this.points = points;
        this.LCM = LCM;
        this.PUV = PUV;
    }
}
