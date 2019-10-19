package dp;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if(amount < 1) return 0;
		// M[i] denotes the minimum number of coins to make up i
		int[] M = new int[amount + 1]; 
		int cur = 1; 
		while (cur <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (cur >= coin && M[cur - coin] != -1) {
					int tmp = M[cur - coin] + 1;
					min = min < 0 ? tmp : Math.min(min, tmp);
				}
			}
			M[cur] = min;
			cur++;
		}
		return M[amount];
	}
}
