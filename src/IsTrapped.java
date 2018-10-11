// https://codefights.com/challenge/G3wGauCq7PnkA7HjE/solutions/KMsNHmCLxGvjTFgLe
boolean IsTrapped(String w, String l) {
    if(Long.parseLong(w) % 2 == 0 && Long.parseLong(l) % 2 == 0)
        return false;
    return true;
}
