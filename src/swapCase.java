String swapCase(String text) {
    char[] chars = text.toCharArray();
    for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
    }
    return new String(chars);
}

/*
Change the capitalization of all letters in a given string.
Example
For text = "Hello", the output should be
swapCase(text) = "hELLO".
*/
