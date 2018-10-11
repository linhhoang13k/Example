int[] metroCard(int lastNumberOfDays) {
    if (lastNumberOfDays == 30 || lastNumberOfDays == 28) {
        int[] ans = {31};
        return ans;
    }
    else {
        int[] ans = {28, 30, 31};
        return ans;
    }
}
