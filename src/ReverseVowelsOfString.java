class ReverseVowelsOfString {
    String reverseVowelsOfString(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> vowels = new Stack<>();
        Queue<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                vowels.push(arr[i]);
                indexes.add(i);
            }
        }
        while (!vowels.isEmpty()) {
            arr[indexes.remove()] = vowels.pop();
        }
        return new String(arr);
    }

    boolean isVowel(char c) {
        switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            return true;
        default:
            return false;
        }
    }
}