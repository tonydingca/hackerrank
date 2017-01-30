package hackerrank;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
// Kadane's Algorithm

public class MaxProfile {

	public int maxProfit(int[] prices) {
        if(prices.length < 1)
            return 0;
        int maxPro = 0;
        int n = prices.length;
        
        //Kadane's Algorithm
        int curMax = 0;
        for(int i = 1; i<n; i++){
            curMax += prices[i] - prices[i-1];
            if(curMax<0){
                curMax = 0;
            }
            maxPro = Math.max(maxPro, curMax);
        }
        return maxPro;
    }
	//Find Max Profile array start and end index
	public int[] maxProfitWithIndex(int[] prices) {
		int[] index = new int[2];
        if(prices.length < 1)
            return index;
        int maxPro = 0;
        int n = prices.length;
        
        //Kadane's Algorithm
        int curMax = 0;
        index[0] = 0;
        for(int i = 1; i<n; i++){
            curMax += prices[i] - prices[i-1];
            if(curMax<0){
                curMax = 0;
                index[0] = i;
            }
            if(curMax>maxPro){
            	maxPro = curMax;
            	index[1] = i;
            }
        }
        return index;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		MaxProfile solution = new MaxProfile();
		System.out.println(solution.maxProfit(prices));
		System.out.println(Arrays.toString(solution.maxProfitWithIndex(prices)));
		
	}

}
