public class RainbowOfClarity {
    boolean isDigit(char symbol) {
        return Character.isDigit(symbol);
    }

    String lineEncoding(String s) {
        String n = "";
        char pop = s.charAt(0);
        int il = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pop) {
                il++;
                pop = s.charAt(i);
            } else {
                if (il == 1) n += Character.toString(s.charAt(i - 1));
                else n += Integer.toString(il) + Character.toString(s.charAt(i - 1));
                il = 1;
                pop = s.charAt(i);
            }
        }
        if (il == 1) n += Character.toString(s.charAt(s.length() - 1));
        else n += Integer.toString(il) + Character.toString(s.charAt(s.length() - 1));
        return n;
    }

    int chessKnight(String cell) {
        int mH = 0;
        int mV = 0;
        int a = 0;
        int b = 0;
        mH = Math.min('h' - cell.charAt(0), cell.charAt(0) - 'a');
        mV = Math.min(8 - Integer.parseInt(Character.toString(cell.charAt(1))), Integer.parseInt(Character.toString(cell.charAt(1))) - 1);
        if (mH > 2) a = 0;
        else a = 2 - mH;
        if (mV > 2) b = 0;
        else b = 2 - mV;
        if ((a + b) == 0) return 8;
        else if ((a + b) == 1) return 6;
        else if ((a + b) == 2) return 4;
        else if ((a + b) == 3) return 3;
        else return 2;
    }

    int deleteDigit(int n) {
        StringBuilder result = new StringBuilder("" + n);

        for (int i = 1; i < Integer.toString(n).toCharArray().length; i++) {
            if (Integer.toString(n).charAt(i - 1) < Integer.toString(n).charAt(i)) {
                result.deleteCharAt(i - 1);
                break;
            }
        }
        if (result.length() == Integer.toString(n).length()) result.deleteCharAt(Integer.toString(n).length() - 1);
        return Integer.parseInt(String.valueOf(result));
    }
}
