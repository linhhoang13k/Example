boolean pairOfShoes(int[][] shoes) {
    ArrayList al = new ArrayList();
    ArrayList bl = new ArrayList();
    for(int i = 0 ; i < shoes.length ; i++){
        if(shoes[i][0] == 1)
            al.add(shoes[i][1]);
        else
            bl.add(shoes[i][1]);
    }
    for(int i = 0 ; i < al.size() ; i++){
        int x = (int)al.get(i);
        al.remove(new Integer(x));
        if(!bl.contains(x))
            return false;
        bl.remove(new Integer(x));
    }
    return al.size() == bl.size() ? true : false;
}
