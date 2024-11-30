package PROJECT.PROJECT;

public class Anagram {
	
	public static void main(String[] args) {
		
		String s1 = "abcdef";
		String s2 = "efbcad";
		int[] ch1 = new int[256];
		int[] ch2 = new int[256];
		
		for(int i=0;i<s1.length();i++) {
			char x = s1.charAt(i);
			char y = s2.charAt(i);
			ch1[(int)x]++;
			ch2[(int)y]++;
		}
		
		int flag=0;
		
		for(int j=0;j<256;j++) {
			System.out.println(ch1[j]+".."+ch2[j]);
			
		}
		
		for(int j=0;j<256;j++) {
			if(ch1[j]!=ch2[j]) {
				flag=1;
				break;
			}
		}
		
		if(flag==0) {
			System.out.println("Strings are anagram");
		}
		else {
			System.out.println("Strings are not anagram");
		}
		
	}

}
