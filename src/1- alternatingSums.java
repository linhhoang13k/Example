int[] alternatingSums(int[] a) {

    int[] teamWeight = new int[2];
    
    for(int i =0; i < a.length ; i++){
        
    teamWeight[i%2] +=a[i]; 
        
    }
return teamWeight;
}
