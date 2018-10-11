/**
 * Asana is exploring a smart-workload feature designed to streamline task assignment between coworkers. Newly created tasks will be automatically assigned to the team member with the lightest workload. For the ith person the following information is known:

namesi - their name, a string containing only uppercase and lowercase letters;
statusesi - their vacation indicator status, which is true if the person is on a vacation, or false otherwise;
projectsi - the number of projects they are currently involved in;
tasksi - the number of tasks assigned to the report.
If a person's vacation indicator value is set to true, this means they are on vacation and cannot be assigned new tasks. Conversely, a vacation indicator value of false means they are open to receive task assignments.

Asana sorts team members according to their availability. Person A has a higher availability than person B if they have fewer tasks to do than B, or if these numbers are equal but A has fewer assigned projects than B. Put another way, we can say that person A has a higher availability than person B if their (tasks, projects) pair is less than the same pair for B.

Your task is to find the name of the person with the highest availability. It is guaranteed that there is exactly one such person.
 * 
 * **/
     static String smartAssigning(String[] names, boolean[] statuses, int[] projects, int[] tasks) {
         String ideal_person=names[0];
         int position=0;
         for(int i=0; i<statuses.length; i++){
             if(!statuses[i]){
                 if( tasks[position]>tasks[i]){ 
                     position=i;
                     
                 } 
                     if(tasks[position]==tasks[i]){
                         if(projects[position]>=projects[i]){
                             position=i;
                         }
                     }
                 
                 
                 
                 
             }
         }
        return names[position];
}

