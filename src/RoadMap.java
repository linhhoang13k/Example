package com.codefights;

import javafx.concurrent.Task;

import java.util.*;

public class RoadMap {

    public static void main(String[] args) {
        RoadMap m = new RoadMap();

        String[][] tasks = new String[5][];
        tasks[0] = new String [] {"A", "2017-02-01", "2017-03-01", "Sam", "Evan", "Troy"};
        tasks[1] = new String [] {"B", "2017-01-16", "2017-02-15", "Troy"};
        tasks[2] = new String [] {"C", "2017-02-13", "2017-03-13", "Sam", "Evan"};
        tasks[3] = new String [] {"D", "2017-02-01", "2017-03-01", "Sam", "Evan", "Troy"};
        tasks[4] = new String [] {"E", "2017-02-01", "2017-03-01", "Sam", "Evan", "Troy"};


        String[][] queries = new String[2][];
        queries[0] = new String[]{"Evann", "2017-03-10"};
        queries[1] = new String[]{"Troy", "2017-02-04"};

        m.roadmap(tasks, queries);

    }



    String[][] roadmap(String[][] tasks, String[][] queries) {

        String [][] result = new String[queries.length][];

        List<TaskDetails> taskList = new ArrayList<>();

        for (int i = 0; i < tasks.length; i++) {
            String [] taskDetail = tasks[i];

            String id = taskDetail[0];
            Integer startDate = Integer.valueOf(taskDetail[1].replaceAll("-",""));
            Integer endDate = Integer.valueOf(taskDetail[2].replaceAll("-",""));
            Set<String> users = new HashSet<>();

            for (int j = 3; j < taskDetail.length; j++) {
                String user = taskDetail[j];

                users.add(user);
            }

            TaskDetails det = new TaskDetails(id, startDate, endDate, users);
            taskList.add(det);
        }

        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            Integer lookupDate = Integer.valueOf(query[1].replaceAll("-", ""));
            String lookupPerson = query[0];

            List<TaskDetails> uniqueTasks = new ArrayList<>(); //convert this to array in the end

            for (int j = 0; j < taskList.size(); j++) {
                TaskDetails details = taskList.get(j);

                Integer startDate = details.startDate;
                Integer endDate = details.endDate;

                if(startDate <= lookupDate && lookupDate <= endDate && details.people.contains(lookupPerson)){
                    uniqueTasks.add(details);
                }
            }

            Collections.sort(uniqueTasks, new TaskDetails());

            String [] arr = new String[uniqueTasks.size()];

            for (int j = 0; j < uniqueTasks.size(); j++) {
                arr[j] = uniqueTasks.get(j).toString();
            }

            result[i] = arr;
        }
        return result;
    }

    class TaskDetails implements Comparator<TaskDetails> {

        String taskID;
        Integer startDate;

        Integer endDate;
        Set<String> people;

        public TaskDetails(){}

        public TaskDetails(String taskID, Integer startDate, Integer endDate, Set<String> people) {
            this.taskID = taskID;
            this.startDate = startDate;
            this.endDate = endDate;
            this.people = people;
        }

        @Override
        public int compare(TaskDetails o1, TaskDetails o2) {
            Integer ed1 = o1.endDate;
            Integer ed2 = o2.endDate;

            if(ed1.equals(ed2)) {
                return o1.taskID.compareTo(o2.taskID);
            } else {
                return ed1.compareTo(ed2);
            }
        }

        @Override
        public String toString(){
            return taskID;
        }

    }


}
