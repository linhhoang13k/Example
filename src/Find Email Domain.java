String findEmailDomain(String address) {
    String[] st = address.split("@");
    return st[st.length-1];
}
