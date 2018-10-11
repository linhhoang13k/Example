 class Task implements Comparable<Task> {

        String taskName;
        Date Start;
        Date End;

        public Task(String tName, Date s, Date e) {
            taskName = tName;
            Start = s;
            End = e;
        }

        @Override
        public int compareTo(Task o) {
            if (End.compareTo(o.End) == 0) {
                return taskName.compareTo(o.taskName);
            }
            return End.compareTo(o.End);
        }
    }

    String[][] roadmap(String[][] tasks, String[][] queries) {
        String Date = "";
        HashMap<String, ArrayList<Task>> workers = new HashMap<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < tasks.length; i++) {
            Task newTask = null;
            try {
                newTask = new Task(tasks[i][0], df.parse(tasks[i][1]), df.parse(tasks[i][2]));
            } catch (Exception e) {
                System.out.println("Error Parsing");
            }

            for (int j = 3; j < tasks[i].length; j++) {
                if (workers.get(tasks[i][j]) == null) {
                    ArrayList<Task> ar = new ArrayList<Task>();
                    ar.add(newTask);
                    workers.put(tasks[i][j], ar);
                } else {
                    ArrayList<Task> ar = workers.get(tasks[i][j]);
                    ar.add(newTask);
		    Collections.sort(ar);
                    workers.put(tasks[i][j], ar);
                }
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < queries.length; i++) {
            if (workers.get(queries[i][0]) != null) {
                ArrayList<Task> ar = workers.get(queries[i][0]);
                ArrayList<String> arr = new ArrayList<>();
                for (int j = 0; j < ar.size(); j++) {
                    Task t = ar.get(j);
                    try {
                        Date comp = df.parse(queries[i][1]);
                        if (comp.compareTo(t.Start) != -1 && comp.compareTo(t.End) != 1) {
                            arr.add(t.taskName);
                        }
                    } catch (Exception e) {

                    }
                }
                    result.add(arr);
            }
        }
        String[][] res = new String[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            ArrayList<String> tt = result.get(i);
            res[i] = new String[tt.size()];
            for (int j = 0; j < tt.size(); j++) {
                res[i][j] = tt.get(j);
            }
        }
        return res;
    }
