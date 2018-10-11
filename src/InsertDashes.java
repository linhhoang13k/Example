String insertDashes(String inputString) {
        String[] words = inputString.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = "-" + String.join("-", words[i].split("")) + "-";
            if (words[i].length() > 2) {
                words[i] = words[i].substring(1, words[i].length() - 1);
            }
        }
        String result = "";
        for (int i = 0; i < words.length - 1; i++) {
            result += words[i] + " ";
        }
        return result + words[words.length - 1];
    }
