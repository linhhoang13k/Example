String[] binaryGenerator(String s) {
    int num = Integer.parseInt(s, 2);
    int max = 1 << s.length();
    
    List<String> arr = new ArrayList();
    for (int a = 0; a < max; a++) {
        if ((a & num) == num) {
            String str = Integer.toString(a, 2);
            while (str.length() < s.length())
                str = "0" + str;
            arr.add(str);
        }
    }
    return arr.toArray(new String[arr.size()]);
}

/*
Let's say that binary sequence s generates binary sequence t if:

s and t are of the same length;
for each i such that s[i] = 1 it is true that t[i] = 1.
Given a sequence s, return an array of all the sequences it generates, sorted lexicographically.

For s = "01101", the output should be
binaryGenerator(s) = ["01101", "01111", "11101", "11111"].
*/
