String quadZip(String one, String two, String three, String four) {

  //  one = one.replace("\\", "");
    
    StringBuilder sone = new StringBuilder(one);
    StringBuilder stwo = new StringBuilder(two);
    StringBuilder sthree = new StringBuilder(three);
    StringBuilder sfour = new StringBuilder(four);
    
    String s = "";
    int smallest=one.length();
    if(smallest >= two.length() )
    {
        smallest = two.length();
    }
    if(smallest >= three.length() )
    {
        smallest = three.length();
    }
    if(smallest >= four.length() )
    {
        smallest = four.length();
    }
    System.out.println(smallest);
    while(sone.length() >0 )
    {
        s += sone.charAt(0)+""+stwo.charAt(0)+""+sthree.charAt(0)+""+sfour.charAt(0);
        sone.deleteCharAt(0);
        stwo.deleteCharAt(0);
        sthree.deleteCharAt(0);
        sfour.deleteCharAt(0);
    }
    
    return s;
}
