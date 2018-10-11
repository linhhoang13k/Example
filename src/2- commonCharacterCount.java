int commonCharacterCount(String s1, String s2) {


StringBuffer a = new StringBuffer(s1);
StringBuffer b = new StringBuffer(s2);
int n = 0;
for (int i = 0; i < a.length(); i++) {
for (int j = 0; j < b.length(); j++) {
if (a.charAt(i) == b.charAt(j)) {
n++;
b.deleteCharAt(j);
break;
}
}

    }
return n;

}

