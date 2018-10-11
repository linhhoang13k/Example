/*
 Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> hm = new HashMap<String, List>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList());
            }
            hm.get(key).add(s);
        }
        return new ArrayList(hm.values());
    }
}