package PROJECT.PROJECT;

public class ReverseString {
	
	public static void main(String[] args) {
		
		
		String string = "amitsingh";
		int len = string.length();
		int j;
		String rev ="";
		
		for(j=len-1;j>=0;j-- ) {
			
			rev = rev + string.charAt(j);
		}
		
		System.out.println(rev);
	}

}
