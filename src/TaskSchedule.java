package tiendm.codefight.challenge.may;

import java.util.Arrays;

public class TaskSchedule {
	int tasksScheduling(int workingHours, int[] tasks) {
		for(int i : tasks){
			if(i > workingHours) return -1;
		}
		int count = tasks.length+1, sum = 0;
		boolean[] visited = new boolean[tasks.length];
		Arrays.sort(tasks);
		for(int i = 0; i < tasks.length; i++){
			if(sum + tasks[i] <= workingHours) {
				count--;
				sum += tasks[i];
			}else {
				sum = tasks[i];
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		TaskSchedule task = new TaskSchedule();
		System.out.println(task.tasksScheduling(15, new int[]{4, 15, 6, 3, 13, 4, 7, 14, 8, 15, 5, 8}));
	}
}
