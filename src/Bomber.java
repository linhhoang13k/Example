package interviewpractice.commonTechniquesAdvanced;

/**
 * @author benmakusha
 */
public class Bomber {

    int bomber(char[][] field) {
        int max = 0;
        if (field.length == 0) {
            return 0;
        }

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[0].length; j++) {
                int cnt = 0;
                int k1 = 0, k2 = 0, k3 = 0, k4 = 0;
                if (field[i][j] == '0') {

                    while (i - k1 >= 0) {
                        if (field[i - k1][j] == 'E') {
                            cnt++;
                        } else if (field[i - k1][j] == 'W') {
                            break;
                        }
                        k1++;
                    }
                    while (j - k2 >= 0) {
                        if (field[i][j - k2] == 'E') {
                            cnt++;
                        } else if (field[i][j - k2] == 'W') {
                            break;
                        }
                        k2++;
                    }
                    while (i + k3 < field.length) {

                        if (field[i + k3][j] == 'E') {
                            cnt++;
                        } else if (field[i + k3][j] == 'W') {
                            break;
                        }
                        k3++;
                    }
                    while (j + k4 < field[0].length) {
                        if (field[i][j + k4] == 'E') {
                            cnt++;
                        } else if (field[i][j + k4] == 'W') {
                            break;
                        }
                        k4++;
                    }
                }
                //System.out.println("cnt= " + cnt + " @ " + "i: " + i + " j: " + j);
                max = Math.max(max, cnt);
            }

        }
        return max;
    }
}
