package decide;

public class PUMMethods {
    // Implement the methods for section 2.2 in this class

    /**
     * Method used to generate Preliminary Unlocking Matirx (PUM) given CMV and LCM, based on section 2.2.
     * 
     * @param CMV : Condition Met Vector
     * @param LCM : Logical Connector Matrix
     * @return PUM
     */
    public static boolean[][] PUM(boolean[] CMV, Connector[][] LCM) {
        assert (CMV.length == CMVMethods.NUMLIC && LCM.length == CMVMethods.NUMLIC && LCM[0].length == CMVMethods.NUMLIC);

        boolean[][] PUM = new boolean[CMVMethods.NUMLIC][CMVMethods.NUMLIC];

        for (int i = 0; i < CMVMethods.NUMLIC; i++) {
            for (int j = 0; j < CMVMethods.NUMLIC; j++) {
                if (LCM[i][j] == Connector.NOTUSED) {
                    PUM[i][j] = true;
                }
                else if (LCM[i][j] == Connector.ANDD) {
                    PUM[i][j] = CMV[i] && CMV[j];
                }
                else if (LCM[i][j] == Connector.ORR) {
                    PUM[i][j] = CMV[i] || CMV[j];
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return PUM;
    }
}
