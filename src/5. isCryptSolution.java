/*
A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.
*/

boolean isCryptSolution(String[] crypt, char[][] solution) {
    HashMap<Character, Character> sol = new HashMap<Character, Character>();
    for(int i = 0; i < solution.length; i++) sol.put(solution[i][0], solution[i][1]);
    String[] ans = new String[crypt.length];
    for(int i = 0; i < crypt.length; i++){
        ans[i] = "";
        for(int j = 0; j < crypt[i].length(); j++){
            ans[i] = ans[i] + sol.get(crypt[i].charAt(j));
        }
    }
    for(int i = 0; i < ans.length; i++){
        ans[i] = Integer.parseInt(ans[i]) + "";
    }
    if(Integer.parseInt(ans[0]) + Integer.parseInt(ans[1]) == Integer.parseInt(ans[2])){
        if(ans[0].length() == crypt[0].length() && ans[1].length() == crypt[1].length() && ans[2].length() == crypt[2].length()) return true;
        else return false;
    }
    return false; 
    
}
