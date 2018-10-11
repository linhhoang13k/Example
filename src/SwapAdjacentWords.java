class SwapAdjacentWords {
    String swapAdjacentWords(String s) {
        return s.replaceAll("(\\b\\w+) (\\w*\\b)", "$2 $1");
      }
}