package decide;

public class FUVMethods {
    // Implement the methods for section 2.3 in this class

    /**
     * Method used to generate Final Unlocking Vector (FUV) given PUV and PUM, based on section 2.3.
     * 
     * @param PUV : Preliminary Unlocking Vector
     * @param PUM : Preliminary Unlocking Matrix
     * @return FUV
     */
    public static boolean[] FUV(boolean[] PUV, boolean[][] PUM) {
        assert (PUV.length == CMVMethods.NUMLIC && PUM.length == CMVMethods.NUMLIC && PUM[0].length == CMVMethods.NUMLIC);

        boolean[] FUV = new boolean[CMVMethods.NUMLIC];
        
        for (int i = 0; i < CMVMethods.NUMLIC; i++) {
            FUV[i] = true;
            if (PUV[i]) {
                for (int j = 0; j < CMVMethods.NUMLIC; j++) {
                    if (j == i) continue;
                    if (!PUM[i][j]) {
                        FUV[i] = false;
                        break;
                    }
                }
            }
        }
        return FUV;
    }
}
