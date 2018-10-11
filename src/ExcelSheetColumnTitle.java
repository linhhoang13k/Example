class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
          int remainder = 0;
        String result = "";
        while(n>0){
            remainder = (n-1)%26;
            n = (n-1)/26;
            result = result + (char)(remainder+65);
        }
        return new StringBuilder(result).reverse().toString();
    }
}