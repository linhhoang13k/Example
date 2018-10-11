// Short & simple
boolean bishopAndPawn(String bishop, String pawn) {
    
    return Math.abs(bishop.charAt(0)-pawn.charAt(0)) == Math.abs(bishop.charAt(1) - pawn.charAt(1));
}

// Detailed solution
boolean bishopAndPawn(String bishop, String pawn) {
    String letters = "abcdefgh";
    int currPos = letters.indexOf(String.valueOf(bishop.charAt(0)));
    int num = Integer.parseInt(String.valueOf(bishop.charAt(1)));
    
    List<String> possMoves = new ArrayList<>();
    
    int letInd = currPos-1;
    int numInd = num-1;
    
    while(letInd >= 0 && numInd >= 1) {
        String temp = String.valueOf(letters.charAt(letInd)) + String.valueOf(numInd);
        numInd--;
        letInd--;
        possMoves.add(temp);
    }
    
    letInd = currPos-1;
    numInd = num+1;
    
    while (letInd >= 0 && numInd <= 8) {
        String temp = String.valueOf(letters.charAt(letInd)) + String.valueOf(numInd);
        numInd++;
        letInd--;
        possMoves.add(temp);
    }
    
    letInd = currPos+1;
    numInd = num-1;
    
    while (letInd < 8 && numInd >= 1) {
        String temp = String.valueOf(letters.charAt(letInd)) + String.valueOf(numInd);
        numInd--;
        letInd++;
        possMoves.add(temp);
    }
    
    letInd = currPos+1;
    numInd = num+1;
    
    while (letInd < 8 && numInd <= 8) {
        String temp = String.valueOf(letters.charAt(letInd)) + String.valueOf(numInd);
        numInd++;
        letInd++;
        possMoves.add(temp);
    }
    
    for (String s: possMoves) {
        System.out.println(s);
    }
    
    return possMoves.contains(pawn);
}
