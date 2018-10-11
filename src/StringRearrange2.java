package in.mkp.basic.level7;

/**
 * Created by mkumar on 3/6/17.
 */
public class StringRearrange2 {

    class Word {
        boolean selected;
        String word;

        Word(final String word) {
            this.word = word;
        }
    }

    public static void main(String args[]) {

        StringRearrange2 stringRearrange = new StringRearrange2();
        //String[] str = {"abc","abd", "cdd"};
        String[] str = {"abc","xbc","xxc","xbc","aby","ayy","aby"};
        //String[] str = {"abc", "abc", "abx", "abx", "axx"};
        System.out.println(stringRearrange.stringsRearrangement(str));
    }



    boolean stringsRearrangement(String[] a) {
        int n = a.length;

        int [] degree = new int[n];

        // check if this graph has Hamiltonian path
        // Theorem 1 (Dirac, 1952): Let G be a graph with n ≥ 3 vertices. If each vertex
        // of G has deg(v) ≥ n/2, then G is Hamiltonian
        //
        // Theorem 2 (Ore, 1960): A graph is Hamiltonian if and only if its closure is Hamiltonian
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (differByOne(a[i], a[j]))
                    degree[i] ++;
            }


        // Creating a closure of a Graph G.
        // Suppose G is a graph on n vertices. Then the closure of G, written [G], is constructed
        // by adding edges that connect pairs of non-adjacent vertices u and v for
        // which
        // deg(u) + deg(v) ≥ n
        // One continues recursively, adding new edges until all nonadjacent
        // pairs u, v satisfy
        // deg(u) + deg(v) < n.
        //        The graphs G and [G] have the same vertex set—I’ll call it V —but the edge set
        // of [G] may contain extra edges. 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!differByOne(a[i], a[j]) && degree[i] + degree[j] >= n) {
                    degree[i]++;
                    degree[j]++;
                }
            }
        }

        // Verifying Theorem 1
        for (int d : degree)
            if (d<n/2) return false;

        return true;
    }


    boolean differByOne(String s1, String s2) {
        int len = s1.length();
        int diff = 0;
        for (int i = 0; i < len; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1 ? true : false;
    }

    boolean allSelected(Word[] words) {
        for (Word w : words) {
            if (!w.selected) {
                return false;
            }
        }
        return true;
    }

}
