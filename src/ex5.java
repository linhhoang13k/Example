int shapeArea(int n) {
    int area = 1;
    for (int i = 1; i<= n-1; i++){
        if(n==1){
            return n;
        }
        else{
            area+=4*i;
        }
    }
    return area;
}
