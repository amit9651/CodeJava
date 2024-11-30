package Test2;

import java.nio.channels.Pipe.SourceChannel;

/*The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or 
 * sell the stock at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

Examples:

Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865*/


public class Problem03 {
	
	public static void main(String[] args) {
		
		int[] prices = {86 ,92 ,24, 5, 34, 72, 68, 52, 27, 95, 41, 28, 35};
		int n = prices.length;
		
		int max = prices[0];
		int min = prices[0];
		int profit = 0;
		
		for(int i=1;i<n;i++) {
			
			if(prices[i]>=prices[i-1]) {
				max = prices[i];
				if(i==n-1) {
					profit = profit + max - min;

				}
			}
			else {
				profit = profit + max - min;
				min = prices[i];
				max = prices[i];
			}
			System.out.println("profit: "+profit);
			
		}
		
		System.out.println(profit);
	}

}
