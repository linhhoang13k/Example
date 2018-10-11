Given a string, find the number of different non-empty substrings in it.

Example

For inputString = "abac", the output should be
differentSubstrings(inputString) = 9.
They are:

"a", "b", "c",
"ab", ac", "ba",
"aba", "bac",
"abac"

int differentSubstrings(String s) {
     ArrayList<String> l = new ArrayList();
      for(int i = 0 ; i < s.length() ;i++){
        String r = "";
        for(int j = i ; j < s.length() ;j++){
          r += String.valueOf(s.charAt(j));
          l.add(r);
        }
      }
      HashSet<String> h = new HashSet();
      for(int i = 0 ; i < l.size() ;i++){
        h.add(l.get(i));
      }
      return h.size();
}
