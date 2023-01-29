package decide;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import static decide.Connector.*;

import static decide.PUMMethods.*;

public class PUMMethodsTest {
    
    @Test
    void testPositivePUM() {
        boolean[] CMV = {false, true, true, true, false, false, false, false, false, false, false, false, false, false, false};
        Connector[][] LCM = {
            {ANDD, ANDD, ORR, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {ANDD, ANDD, ORR, ORR, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {ORR, ORR, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {ANDD, ORR, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED}
        };
        boolean PUM[][] ={
            {true, false, true, false, true, true, true, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        };

        assertTrue(neglectDiagonalEquals(PUM(CMV, LCM), PUM));
    }

    @Test
    void testNegativePUM() {
        boolean[] CMV = {false, true, true, true, false, false, false, false, false, false, false, false, false, false, false};
        Connector[][] LCM = {
            {ANDD, ANDD, ORR, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {ANDD, ANDD, ORR, ORR, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {ORR, ORR, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {ANDD, ORR, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, ORR, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, ORR, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, ORR, NOTUSED, NOTUSED, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED},
            {NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED}
        };
        boolean PUM[][] ={
            {true, false, true, false, true, true, true, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true, true, false, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, false, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, false, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, false, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, false, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        };

        assertFalse(neglectDiagonalEquals(PUM(CMV, LCM), PUM));
    }

    static boolean neglectDiagonalEquals(boolean[][] a, boolean[][] b) {
        int numRow = a.length;
        int numCol = a[0].length;
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (i == j) continue;
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
