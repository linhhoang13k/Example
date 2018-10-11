package evg.codefights.graphs;

public class KingdomRoads {

    boolean newRoadSystem(boolean[][] roadRegister) {
        for (int k = 0; k < roadRegister.length; k++) {
            int s1 = 0;
            int s2 = 0;
            for (int i = 0; i < roadRegister.length; i++) {
                if (roadRegister[k][i]) {
                    s1++;
                }
                if (roadRegister[i][k]) {
                    s2++;
                }
            }
            if (s1 != s2) {
                return false;
            }
        }
        return true;
    }

}
