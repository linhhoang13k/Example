class ExcelSheetColumnNumber {
    int excelSheetColumnNumber(String s) {
        int last = s.length() - 1;
        int ans = 0;
        int power = 1;
        while (last >= 0) {
            ans += getValue(s.charAt(last)) * power;
            power *= 26;
            last--;
        }
        return ans;
    }

    int getValue(char c) {
        return (int) c - (int) 'A' + 1;
    }
}