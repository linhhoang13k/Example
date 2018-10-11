class AddBinaryStrings {
    String addBinaryStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int digit = Math.max(alen, blen);
        for (int i = 0; i <= digit; i++) {
            char as = (alen - i) >= 0 ? a.charAt(alen - i) : '0';
            char bs = (blen - i) >= 0 ? b.charAt(blen - i) : '0';
            char cur = '0';
            if (as == '0' && bs == '0') {
                if (carry == '1') {
                    carry = '0';
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            } else if ((as == '0' && bs == '1') || (as == '1' && bs == '0')) {
                if (carry == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            } else if (as == '1' && bs == '1') {
                if (carry == '0') {
                    carry = '1';
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
        }
        if (carry == '1') {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}