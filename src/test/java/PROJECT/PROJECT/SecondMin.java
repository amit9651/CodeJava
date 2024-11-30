package PROJECT.PROJECT;

public class SecondMin {
	
	public static void main(String[] args) {
		
		Integer[] arr = {1,1,2,-1};
		
		int min = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		int size = arr.length;
		
		for(int i=0;i<size;i++) {
			
			if(size<2) {
				System.out.println("No 2nd min exist !!!");
			}
			else if(arr[i]<min) {
				min2 = min;
				min = arr[i];
			}
			else if(arr[i]<min2 && arr[i]!=min) {
				min2 = arr[i];
			}
			
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println("No 2nd min exist !!!");
		}
		else {
			System.out.println("2nd min is: "+min2);
		}
		
		
	}

}
