boolean tennisSet(int score1, int score2) {
    if(score1 <8 || score2<8){
        if(score1==6 && score2<5 ||score2==6 && score1<5){
            return true;
        }else if(score1==7 && score2>4 && score2<7)
            return true;
        else if(score2==7 && score1>4 && score1<7)
            return true;
    }
    return false;

}
