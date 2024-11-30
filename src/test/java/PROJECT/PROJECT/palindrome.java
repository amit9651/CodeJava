package PROJECT.PROJECT;

public class palindrome {
	
	public static void main(String[] args) {
		
		String str = "abccbaa";
		int len = str.length();
		int i=0;
		int j=len-1;
		int flag=0;
		
		while(i<=j) {
			if(str.charAt(i) != str.charAt(j)) {
				flag=1;
				break;
			}
			i++;
			j--;
		}
		
		if(flag==0) {
			System.out.println("String is palindrome");
		}
		else {
			System.out.println("String is not palindrome");
		}
		
	}

}
