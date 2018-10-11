// https://codefights.com/challenge/gsRkjPcZKypc5zkdc/solutions/9XQDFKfkXtXLgN5XG
String codemania_medal(String u, String g, String s, String b) {
    String[] c = u.split(":");
    String[] d = g.split(":");
    String[] e = s.split(":");
    String[] f = b.split(":");
    String v = "";
    String x = "";
    String y = "";
    String z = "";
    for(int i = 0; i < 3; i++) {
        v += c[i];
        x += d[i];
        y += e[i];
        z += f[i];
    }
    int h = Integer.parseInt(v);
    int i = Integer.parseInt(x);
    int j = Integer.parseInt(y);
    int k = Integer.parseInt(z);
    if(h < k && h > j || h == j)
        return "Bronze";
    if(h < j && h > i || h == i)
        return "Silver";
    if(h < i)
        return "Gold";
    return "None";
}
