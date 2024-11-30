package PROJECT.PROJECT;

public class PalindromeNumber {
	
		public static void main(String[] args) {
			
			int num = 1234321;
			String str = String.valueOf(num); //Integer.toString(num);
			
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
				System.out.println("Number is palindrome");
			}
			else {
				System.out.println("Number is not palindrome");
			}
		}

}
