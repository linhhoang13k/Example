boolean areSimilar(int[] a, int[] b) {
        int test = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                test++;
        Arrays.sort(a);
        Arrays.sort(b);
        return test < 3 && Arrays.equals(a, b);
    }
