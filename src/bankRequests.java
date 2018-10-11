int[] bankRequests(int[] accounts, String[] requests) {
    for(int i = 0; i < requests.length; i++) {
        String [] s = requests[i].split("\\s+");
        if(Integer.parseInt(s[1]) > accounts.length)
            return new int [] {-1 * (i + 1)};
        if(s[0].equals("withdraw")) {
            if(accounts[Integer.parseInt(s[1]) - 1] < Integer.parseInt(s[2]))
                return new int [] {-1 * (i + 1)};
            accounts[Integer.parseInt(s[1]) - 1] -= Integer.parseInt(s[2]);
        }
        else if (s[0].equals("deposit"))
            accounts[Integer.parseInt(s[1]) - 1] += Integer.parseInt(s[2]);
        else if (s[0].equals("transfer")) {
            if(Integer.parseInt(s[2]) > accounts.length || accounts[Integer.parseInt(s[1]) - 1] < Integer.parseInt(s[3]))
                return new int [] {-1 * (i + 1)};
            accounts[Integer.parseInt(s[1]) - 1] -= Integer.parseInt(s[3]);
            accounts[Integer.parseInt(s[2]) - 1] += Integer.parseInt(s[3]);
        }
    }
    return accounts;
}
