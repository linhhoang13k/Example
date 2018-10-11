class IntegerValueOfRomanNumeral {
    int integerValueOfRomanNumeral(String s) {
        int decimal = 0;
        int lastNumber = 0;
        if (!isValid(s)) {
            return -1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
            case 'M':
                decimal = process(1000, lastNumber, decimal);
                lastNumber = 1000;
                break;
            case 'D':
                decimal = process(500, lastNumber, decimal);
                lastNumber = 500;
                break;
            case 'C':
                decimal = process(100, lastNumber, decimal);
                lastNumber = 100;
                break;
            case 'L':
                decimal = process(50, lastNumber, decimal);
                lastNumber = 50;
                break;
            case 'X':
                decimal = process(10, lastNumber, decimal);
                lastNumber = 10;
                break;
            case 'V':
                decimal = process(5, lastNumber, decimal);
                lastNumber = 5;
                break;
            case 'I':
                decimal = process(1, lastNumber, decimal);
                lastNumber = 1;
                break;
            }
        }
        return decimal;
    }

    public static int process(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

    public static boolean isValid(String s) {
        if (s.contains("VV") || s.contains("DD") || s.contains("LL") || s.contains("IIII") || s.contains("XXXX")
                || s.contains("CCCC") || s.contains("VX") || s.contains("XL") || s.contains("VL") || s.contains("IL")
                || s.contains("IC") || s.contains("VC") || s.contains("LC") || s.contains("ID") || s.contains("VD")
                || s.contains("XD") || s.contains("LD") || s.contains("IM") || s.contains("VM") || s.contains("XM")
                || s.contains("LM") || s.contains("DM")) {
            return false;
        }
        return true;
    }
}