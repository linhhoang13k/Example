package codefights;

public class Some {

    /*
    public static void main(String[] args) {

        String[][] dishes = new String[][] { { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" }, { "Pizza", "Tomato", "Sausage", "Sauce", "Dough" },
            { "Quesadilla", "Chicken", "Cheese", "Sauce" }, { "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } };

        final String[][] values = groupingDishes(dishes);
        for (String[] a : values)
            System.err.println(Arrays.toString(a));

        System.err.println(areFollowingPatterns(new String[] { "cat", "dog", "dog" }, new String[] { "cat", "dog", "dog" }));
        System.err.println(areFollowingPatterns(new String[] { "cat", "dog", "doggy" }, new String[] { "a", "b", "b" }));
    }

    static String[][] groupingDishes(String[][] dishes) {
        Map<String, Set<String>> m = new HashMap<>();
        for (int i = 0; i < dishes.length; i++) {
            String dish = dishes[i][0];
            for (int j = 1; j < dishes[i].length; j++) {
                String ingr = dishes[i][j];
                if (ingr == null)
                    continue;
                m.putIfAbsent(ingr, new TreeSet<>());
                m.get(ingr).add(dish);
            }
        }

        final Map<String, Set<String>> f = m.entrySet().stream().filter(e -> e.getValue().size() > 1).sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        String[][] out = new String[f.size()][];
        int index = 0;
        for (Map.Entry<String, Set<String>> e : f.entrySet()) {
            List<String> l = new ArrayList<>();
            l.add(e.getKey());
            l.addAll(e.getValue());
            out[index] = l.toArray(new String[l.size()]);
            index++;
        }

        return out;
    }

    static boolean areFollowingPatterns(String[] strings, String[] patterns) {
        Map<String, String> msp = new HashMap<>();
        Map<String, String> mps = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String p = patterns[i];
            msp.putIfAbsent(s, p);
            mps.putIfAbsent(p, s);
            if (!Objects.equals(msp.get(s), p)) {
                return false;
            }
            if (!Objects.equals(mps.get(p), s)) {
                return false;
            }
        }
        return true;
    }
    */
}