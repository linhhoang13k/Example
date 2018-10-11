class FlightPlan {
    String flightPlan(String[][] times, String source, String dest) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> destlist = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(times[i][1])) {
                list = map.get(times[i][1]);
            }
            list.add(i);
            map.put(times[i][1], list);
            if (times[i][1].equals(dest)) {
                destlist.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int d : destlist) {
            int time = convertToMin(times[d][3]);
            if (times[d][0].equals(source)) {
                min = Math.min(min, time);
                continue;
            }
            ArrayList<Integer> list = map.get(times[d][0]);
            if (list == null) {
                continue;
            }
            int arriveBy = convertToMin(times[d][2]);
            boolean found = find(times, map, list, source, arriveBy);
            if (!found) {
                continue;
            }
            min = Math.min(min, time);
        }
        if (min == Integer.MAX_VALUE) {
            return "-1";
        }
        return convertBack(min);
    }

    boolean find(String[][] times, HashMap<String, ArrayList<Integer>> map, ArrayList<Integer> list, String source,
            int arriveBy) {
        if (list == null) {
            return false;
        }
        for (int d : list) {
            int arrived = convertToMin(times[d][3]);
            if (arrived <= arriveBy - 60 && times[d][0].equals(source)) {
                return true;
            }
            if (arrived > arriveBy - 60) {
                continue;
            }

            boolean found = find(times, map, map.get(times[d][0]), source, convertToMin(times[d][2]));
            if (found) {
                return true;
            }
        }
        return false;
    }

    int convertToMin(String s) {
        String[] splt = s.split(":");
        int hour = Integer.parseInt(splt[0]);
        int min = Integer.parseInt(splt[1]);
        return hour * 60 + min;
    }

    String convertBack(int time) {
        int min = time % 60;
        int hour = time / 60;
        String minStr = "" + min;
        String hourStr = "" + hour;
        if (minStr.length() < 2) {
            minStr = "0" + minStr;
        }
        if (hourStr.length() < 2) {
            hourStr = "0" + hourStr;
        }
        return "" + hourStr + ":" + minStr;
    }
}