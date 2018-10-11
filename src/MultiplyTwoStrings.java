class MultiplyTwoStrings {
    String multiplyTwoStrings(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        int[] ai = new int[alen];
        int[] bi = new int[blen];
        for(int i = 0; i < alen; i++){
            ai[i] = Integer.parseInt("" + ac[i]);
        }
        for(int i = 0; i < blen; i++){
            bi[i] = Integer.parseInt("" + bc[i]);
        }
        int carry = 0;
        int maxMultSize = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> multsPerDigit = new ArrayList<>();
        for(int i = 0; i < blen; i++){
            sb = new StringBuilder();
            for(int j = 0; j < i; j++){
                sb.append("0");
            }
            int digit = 0;
            carry = 0;
            for(int j = 0; j < alen; j++){
                int multDigit = bi[blen - 1 - i] * ai[alen - 1 - j];
                multDigit += carry;
                carry = multDigit / 10;
                multDigit = multDigit % 10;
                sb.append("" + multDigit);
            }
            if(carry > 0){
                sb.append("" + carry);
            }
            if(sb.length() > maxMultSize){
                maxMultSize = sb.length();
            }
            multsPerDigit.add(sb.toString());
        }
        carry = 0;
        int k = 0;
        sb = new StringBuilder();
        for(int i = 0; i < maxMultSize; i++){
            int digitSum = 0;
            for(String cur : multsPerDigit){
                if(i < cur.length()){
                    digitSum += Integer.parseInt("" + cur.charAt(i));
                }
            }
            digitSum += carry;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            sb.append("" + digitSum);
        }
        if(carry > 0) {
            sb.append("" + carry);
        }
        String ans = sb.reverse().toString();
        if(ans.charAt(0) == '0'){
            return "0";
        }
        return ans;
    }
}