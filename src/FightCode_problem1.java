int[] tasksTypes(int[] deadlines, int day) {
int [] temp=new int[3];
   
    
    
		for (int i = 0; i < deadlines.length; i++) {
            if(deadlines[i]<= day){ 
            temp[0]=temp[0]+1;
        }
        
        else if(deadlines[i]>= day && deadlines[i]<= (day+7)){
            temp[1]=temp[1]+1;
        }
           else temp[2]=temp[2]+1;
		}
    
    
    return temp;
}