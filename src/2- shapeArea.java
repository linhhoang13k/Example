int shapeArea(int n) {
    
         if ( n == 1 ) return 1;
         
         return ( shapeArea(n-1) + (n-2)*4 + 4);

}
