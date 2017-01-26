/**
 * The change-making problem addresses the following question: how can a given amount of money be made with the least number of coins of given denominations?
 * 
 * The class gives two implementations: an iterative one and a recursive one.
 *  
 */
public class CoinChange {

	public int solutionRecursive(int[] coins, int amount){
		if(amount<1)
			return 0;
		return helper(coins, amount, new int[amount]);
	}
	// rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	private int helper(int[] coins, int rem, int[]count){
		if (rem<0) // invalid
			return -1;
		if(rem==0) // completed
			return 0;
		if(count[rem - 1] !=0) // already compute, just return
			return count[rem - 1];
		int min = Integer.MAX_VALUE;
		for(int coin : coins){
			int res = helper(coins, rem - coin, count);
			if(res>=0 && res<min){
				min = res + 1;
			}
		}
		count[rem - 1] = (min==Integer.MAX_VALUE)? -1 : min;
		return count[rem - 1];
	}
	
	// Bottom to Up, dynamic programming
	public int solutionIterative(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int[] dp = new int[amount + 1];
		int sum = 0;

		// Start from 0, one by one to find the min coin change till to amount, 
		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					min = min < 0 ? temp : (temp < min ? temp : min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 3459;
		CoinChange cc = new CoinChange();
		long start1 = System.nanoTime();
		
		int result = cc.solutionIterative(coins, amount);		
		//System.out.println("Iterative = " + result);
		long end1 = System.nanoTime();
		double duration1 = (end1-start1)/1000000.;
		
		long start2 = System.nanoTime();
		result = cc.solutionRecursive(coins, amount);		
		//System.out.println("Recursiv = " + result);
		long end2 = System.nanoTime();
		double duration2 = (end2-start2)/1000000.;

		System.out.println("Result = " + result);
		System.out.println("duration (iterative): " + duration1 + "ms");
		System.out.println("duration (recursive): " + duration2 + "ms");
	}

}
