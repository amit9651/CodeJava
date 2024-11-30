package Test2;

public class Problem04 {
	
	
	
/*Given an array prices[] of length n, representing the prices of the stocks on different days. 
 * The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one 
 * transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

Note: Stock must be bought before being sold.

Examples:

Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
Output: 8*/
	
	public static void main(String[] args) {
		int[] prices = {79 ,2 ,57, 33, 13, 51};
		
		int n = prices.length;
		int profit = 0;
		int min = prices[0];
		int max = prices[0];
		
		for(int i=1;i<n;i++) {
			
			if(prices[i]>prices[i-1] && profit < prices[i] - min) {
				max = prices[i];
				profit = max - min;
			}
			else if(prices[i] < min) {
				min = prices[i];            // min = 2 max = 57 p = 55 
			}
		}
		
		System.out.println(profit);
		
		
	}

}
