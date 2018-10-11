class PairsSum {
    int pairsSum(int[] a) {
        int len = a.length;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int ai : a){
            set.add(ai);
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i != j){
                    if(set.contains(a[i] + a[j])){
                        ans++;
                    }
                }
            }
        }
        return ans/2;
    }
}