package Test2;

/*Given an array arr[]. Push all the zeros of the given array to the right end of the array 
while maintaining the order of non-zero elements. Do the mentioned change in the array in place.

Examples:

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.*/


public class Problem02 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
		int n = arr.length;
		int[] z = new int[n];
		int zero = 0;
		int k=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=0) {
				z[k]=arr[i];
				k++;
			}
			else {
				zero++;
			}
		}
		for(int i=1;i<=zero;i++) {
			z[k] = 0;
			k++;
		}
		
		for(int i=0;i<n;i++) {
			arr[i] = z[i];
		}
		
	}

}
