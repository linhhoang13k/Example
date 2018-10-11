<<<<<<< HEAD
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
     int[] arr= new int[256];

	int record = 0;
	if (s != null && s.length() > 0)
		record = 1;
	else
		return 0;
	int lastIndex =0;
	for (int i = 0; i < s.length(); i++) {
			int code = (int)s.charAt(i);
		    //System.out.println("char is: "+s.charAt(i)+" and code is "+code);
		if (arr[code] != 0 ) {
			int index = arr[code]-1;
			int len =i -lastIndex;
           // System.out.println("index is:"+index+" len is"+len+"record: "+record+" lastIndex: "+lastIndex);
			if(len >record) record =len;
			if(index >= lastIndex)
			lastIndex = index+1;
		} 
	    arr[code] =i+1;
        //System.out.println("arr[code]="+arr[code]);
	}
	if(s.length()- lastIndex >record) record =s.length() - lastIndex ;

	return record;   
    }
=======
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
     int[] arr= new int[256];

	int record = 0;
	if (s != null && s.length() > 0)
		record = 1;
	else
		return 0;
	int lastIndex =0;
	for (int i = 0; i < s.length(); i++) {
			int code = (int)s.charAt(i);
		    //System.out.println("char is: "+s.charAt(i)+" and code is "+code);
		if (arr[code] != 0 ) {
			int index = arr[code]-1;
			int len =i -lastIndex;
           // System.out.println("index is:"+index+" len is"+len+"record: "+record+" lastIndex: "+lastIndex);
			if(len >record) record =len;
			if(index >= lastIndex)
			lastIndex = index+1;
		} 
	    arr[code] =i+1;
        //System.out.println("arr[code]="+arr[code]);
	}
	if(s.length()- lastIndex >record) record =s.length() - lastIndex ;

	return record;   
    }
>>>>>>> 16693ed2c463e617361e7f7dc0aa21e5ed9bfd31
}