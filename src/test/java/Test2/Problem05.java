package Test2;

public class Problem05 {
	
	
/*Given a string S that consists of only alphanumeric characters and dashes. 
 * The string is separated into N + 1 groups by N dashes. Also given an integer K. 

We want to reformat the string S, such that each group contains exactly K characters, except 
for the first group, which could be shorter than K but still must contain at least one character. 
Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted string.


Example 1:

Input: 
S = "5F3Z-2e-9-w", K = 4
Output: "5F3Z-2E9W"*/
	
	
	public static void main(String[] args) {
		
		String S = "5F3Z-2e-9-w";   // 5F3Z - 2  // k=4  => "5-F3Z2
		int K = 4;
		String dummy = "";
		int n = S.length();
		int c;
		if(K>=n) {
			S = ""+S;
		}
		else {
			for(int i=n-1;i>=0;i--) {
				c=K;
				while(c>0) {
					
					
				}
			}
		}
	}

}
