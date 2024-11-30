package PROJECT.PROJECT;

import java.util.ArrayList;


public class StockBuySell {
	
	public static void main(String[] args) {
		
		//ArrayList<Integer> array = new ArrayList<Integer>();
		Integer[] prices = {2,5,1,3,7,9,0};
		
		int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }
        
        System.out.println(profit);

	}
}
