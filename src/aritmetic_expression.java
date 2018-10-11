bool arithmeticExpression(int A, int B, int C) {

    if(A+B==C){
        return true;
    }else if(A-B==C){
        return true;
    }else if(A*B==C){
        return true;
    }else if(A%B==0&&B!=0&&A/B==C){
        return true;
    }else 
        return false;
    
}
