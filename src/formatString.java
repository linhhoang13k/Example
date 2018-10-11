String formatString(String input) {
  return input.replaceAll("\\s{2,}", " ").replaceAll("^\\s+", "").replaceAll("\\s+$", "");
}
/*
Remove extra white-spaces from the given string.

For input = " abc   a aa  a a ", the output should be
formatString(input) = "abc a aa a a".
*/
