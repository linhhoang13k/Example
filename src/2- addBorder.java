String[] addBorder(String[] picture) {

        String[] out = new String[picture.length+2];
        char[]  astrix = new char[picture[0].length()+2];
        Arrays.fill(astrix, '*');

        out[0] = new String(astrix);
        out[out.length-1]= out[0];

        for (int j = 1 ; j <= picture.length;j++){
            out[j] = "*"+picture[j-1]+"*";
        }
        return out;
}
