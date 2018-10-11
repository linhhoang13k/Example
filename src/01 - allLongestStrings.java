String[] allLongestStrings(String[] inputArray) {
    int largest = 0;
        for (String inputArray1 : inputArray) {
            if (inputArray1.length() > largest) {
                largest = inputArray1.length();
            }
        }
        List<String> longest = new ArrayList<>();
        for (String inputArray1 : inputArray) {
            if (inputArray1.length() == largest) {
                longest.add(inputArray1);
            }
        }
        return longest.toArray(new String[longest.size()]);
}