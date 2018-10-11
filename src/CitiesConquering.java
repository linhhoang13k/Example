int[] citiesConquering(int n, int[][] roads) {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < n; i++) graph.put(i, new ArrayList<Integer>());

    for (int[] road: roads) {
        graph.get(road[0]).add(road[1]);
        graph.get(road[1]).add(road[0]);
    }

    int day = 1;
    int[] days = new int[n];
    for (int i = 0; i < n; i++) days[i] = -1;

    while (true) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int city: graph.keySet()) {
            if (graph.get(city).size() <= 1) set.add(city);
        }

        if (set.size() == 0) break;

        for (int city: set) {
            days[city] = day;
            graph.remove(city);
        }

        for (int city: graph.keySet()) {
            for (int cityToRemove: set) {
                graph.get(city).remove(new Integer(cityToRemove));
            }
        }

        day++;
    }

    return days;
}
