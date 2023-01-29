package decide;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class LAUNCHMethodsTest {
    @Test
    void testPostiveLAUNCH() {
        boolean[] fuv = new boolean[15];
        Arrays.fill(fuv, true);
        assertTrue(LAUNCHMethods.LAUNCH(fuv));
    }

    @Test
    void testNegativeLAUNCH() {
        boolean[] fuv = new boolean[15];
        Arrays.fill(fuv, true);
        fuv[0] = false;
        assertFalse(LAUNCHMethods.LAUNCH(fuv));
    }
}
