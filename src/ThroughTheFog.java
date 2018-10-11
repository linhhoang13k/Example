public class ThroughTheFog {
    int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }

    int depositProfit(int deposit, double rate, int threshold) {
        int a = 0;
        for (double i = deposit; i < threshold; i += ((rate / 100)) * i) {
            a++;
        }
        return a;
    }

    int absoluteValuesSumMinimization(int[] a) {
        int min = Integer.MAX_VALUE;
        int wynik = 0;
        int tmp = 0;
        for (int i : a) {
            wynik = 0;
            for (int k : a) {
                wynik += Math.abs(k - i);
            }
            if (wynik < min) {
                min = wynik;
                tmp = i;
            }
        }
        return tmp;
    }

    boolean stringsRearrangement(String[] inputArray) {
        int[][] tab_wsp = new int[inputArray.length][inputArray.length];
        int[] sum = new int[inputArray.length];
        String[] wynik = new String[inputArray.length];
        int inne = 0;
        int min = Integer.MAX_VALUE;
        int id = 0;
        int s_id = 0;
        int ile = 0;

        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                inne = 0;
                for (int k = 0; k < inputArray[0].length(); k++) {
                    if (inputArray[i].charAt(k) != inputArray[j].charAt(k)) {
                        inne++;
                    }
                }
                if (inne == 1) {
                    tab_wsp[i][j] = 1;
                    tab_wsp[j][i] = 1;
                } else {
                    tab_wsp[i][j] = 0;
                    tab_wsp[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < inputArray.length; i++) {
            int s = 0;
            for (int j = 0; j < inputArray.length; j++) {
                if (tab_wsp[i][j] == 1) s++;
            }
            sum[i] = s;
            if (s == 0) return false;
            if (s == 1) ile++;
        }
        if (ile > 2) return false;


        for (int i = 0; i < sum.length; i++) {
            if (sum[i] < min) {
                min = sum[i];
                id = i;
            }
        }
        min = Integer.MAX_VALUE;

        for (int i = 0; i < wynik.length; i++) {
            wynik[i] = inputArray[id];
            s_id = id;
            for (int j = 0; j < tab_wsp[id].length; j++) {
                if (tab_wsp[s_id][j] == 1) {
                    if (sum[j] < min) {
                        min = sum[j];
                        id = j;
                    }
                }
            }
            if (s_id == id && i != wynik.length - 1) return false;
            for (int j = 0; j < inputArray.length; j++) {
                tab_wsp[s_id][j] = 0;
                tab_wsp[j][s_id] = 0;
            }
            min = Integer.MAX_VALUE;
        }

        return true;
    }
}
