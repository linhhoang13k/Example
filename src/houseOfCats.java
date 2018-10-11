ArrayList houseOfCats(int legs) {
    ArrayList al = new ArrayList();
    if(legs % 4 == 0)
        al.add(0);
    else
        al.add(1);
    for(int i = 1 ; (int)al.get(i-1) < legs/2 ; i++){
        al.add((int)al.get(i-1) + 2);
    }
    return al;
}
