
public class Zalgorithm {

	public Zalgorithm(){
	}
	
	public Zalgorithm(String a, String b){
		String c = a + '$' + b;
		int z[] = new int[c.length()];
		System.out.println(c);
		
		getZarr(c, z, a.length());
		
	}
	
	//  Z array for given string str[]
	public void getZarr(String str, int Z[], int patternLength)
	{
	   int n = str.length();
	   int L, R, k;
	
	   // [L,R] make a box which matches with the string prefix before $
	   L = R = 0;
	   for (int i = 1; i < n; ++i)
	   {
	       if (i > R)	// Case 1
	       {
	           L = R = i;
	           while (R<n && str.charAt(R-L) == str.charAt(R))
	               R++;
	           Z[i] = R-L;
	           // Exact Match Checking
	           if(Z[i] == patternLength){
	        	   System.out.println("exact match found at:  " + i);
	           }
	       }
	       else	// Case 2
	       {
	           // k = i-L so k corresponds to number which
	           // matches in [L,R] interval.
	           k = i-L;
	           if (Z[k] < R-i){	// Case 2A
	                Z[i] = Z[k];
	                // Exact Match Checking
	                if(Z[i] == patternLength){
	 	        	   System.out.println("exact match found at:  " + i);
	 	            }
	           }
	           else	// Case 2B
	           {	
	               //  else start from R and check manually
	               L = i;
	               while (R<n && str.charAt(R-L) == str.charAt(R))
	                   R++;
	               Z[i] = R-L;
	               // Exact Match Checking
		           if(Z[i] == patternLength){
		        	   System.out.println("exact match found at:  " + i);
		           }
	           }
	       }
	   }
	   System.out.println("Reached end of string, terminating.");
	}
}
