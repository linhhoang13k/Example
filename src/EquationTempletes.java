package codeFight;

public class EquationTempletes {

	
	
	boolean equationTemplate(int[] v) {
		int a=v[0],b=v[1],c=v[2],d=v[3];
		    
		    return a*b==c*d || a*c==b*d || a*d==b*c || a==b*c*d || b==a*c*b || c==a*b*d || d==b*c*a || a*c*d==b;
		}

	boolean equationTemplate1(int[] values) {

	    int len = values.length;
	    for(int i=0;i<len;i++){
	         int mul = 1;
	        for(int j=0;j<len;j++){
	            if(i!=j){
	                mul *=values[j];
	            }
	        }
	        if(mul == values[i]){
	            return true;
	        }
	    }
	    for(int i=0;i<len;i++){
	        for(int k=i+1;k<len;k++){
	                int mul = 1;
	                for(int j=0;j<len;j++){
	                    if(i!=j && k!=j){
	                        mul *=values[j];
	                    }
	                }
	                if(mul == values[i]*values[k]){
	                    return true;
	                }
	        }
	    }
	    return false;


	}

}
