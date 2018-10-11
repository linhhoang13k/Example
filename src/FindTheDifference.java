class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] temp1 = s.toCharArray();
        char[] temp2 = t.toCharArray();
        int sum = 0;
        System.out.println("loop");
        for(int i=0; i<temp1.length; i++){
            sum = sum+(int)temp1[i];
        }
        for(int i=0; i<temp2.length; i++){
            sum = sum-(int)temp2[i];
        }
        return (char)(Math.abs(sum));

    }
}