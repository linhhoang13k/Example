class FindTheNumbers {
    int[] findTheNumbers(int[] a) {
        int m_xor_n = 0;
        for (int i : a) {
            m_xor_n ^= i;
        }
        int m = 0;
        int n = 0;
        int last = m_xor_n & ~(m_xor_n - 1);
        for (int i : a) {
            if ((i & last) == 0) {
                m ^= i;
            } else {
                n ^= i;
            }
        }
        int[] res = new int[2];
        if (m < n) {
            res[0] = m;
            res[1] = n;
        } else {
            res[0] = n;
            res[1] = m;
        }
        return res;
    }
}