boolean regularExpressionMatching(String s, String p) {
    char[] schars = s.toCharArray();
    char[] pchars = p.toCharArray();
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add((schars.length)*100 + pchars.length);
    while (queue.size() > 0) {
        Integer next = queue.poll();
        int i = next / 100;
        int j = next % 100;
        if (checkMatching(schars, pchars, i, j, queue))
            return true;
    }
    return false;
}

/* - checking backwards, assuming endings are matched.
 * - queue is needed to process *, as it can match from any index 0 to i.
 * - for simplicity indexes are counted from 0
 * - complexity dependes on number of * in pattern
*/
private boolean checkMatching(char[] schars, char[] pchars, int i, int j, Queue<Integer> queue){
    Boolean result = null;
    while (i >= 0 && j > 0){
        if (i > 0 && (schars[i-1] == pchars[j-1] 
                      || pchars[j-1] == '.')) {i--;j--;}
        else if (pchars[j-1] == '*') {
            j--;
            if (j <= 0) {
                System.out.println("Pattern is corrupted! " +
                                   "No symbol before *");
                return false;
            }
            if (pchars[j-1] == '.'){
                j--;
                if (j > 0) {
                    while (i > 0) {
                        if (schars[i-1] == pchars[j-1] ||
                           pchars[j-1] == '.' ||
                           pchars[j-1] == '*')
                            queue.add(i*100 + j);
                        i--;
                    }
                } else {
                    result = true;
                    break;
                } 
            } else {
                queue.add(i*100 + j-1);
                while (i > 0 && schars[i-1] == pchars[j-1]){
                    queue.add((i-1)*100 + j-1);
                    i--;
                }
                j--;
            }
        } else {
            result = false;
            break;// while loop
        }
    }
    
    if (result == null) {
        if (i == 0 && j == 0) result = true;
        else result = false;    
    }
    return result;
}

