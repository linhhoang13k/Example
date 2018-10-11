// https://codefights.com/challenge/vACv5XkFeg54A6rtr/solutions/x9pWa28bh6BaC9Ysi
int modulo10(String a, String b) {
    return Character.getNumericValue(a.charAt(a.length() - 1)) * Character.getNumericValue(b.charAt(b.length() - 1)) % 10;
}
