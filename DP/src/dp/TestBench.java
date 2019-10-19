package dp;
import java.util.*;

public class TestBench {
	public static void main(String[] args) {
		//		DictionaryWordI d1 = new DictionaryWordI();
		//		String[] dict = new String[]{"abc","bcd","def"};
		//		System.out.println(d1.canBreak("bcdbcdabc", dict));
		//		JumpGame jg = new JumpGame();
		//		jg.canJump(new int[]{4,2,1,2,0,0});
		//		MinJump mj = new MinJump();
		//		System.out.println(mj.minJump(new int[] {1,2,0}));
		//		LargestSubsquareSurroundedByOne ls = new LargestSubsquareSurroundedByOne();
		//		int[][] matrix = {{1,0,1,1,1},{1,1,1,1,1},{1,1,0,1,0},{1,1,1,1,1},{1,1,1,0,0}};
		//		int[][] matrix = {{1,1,1,1},{1,0,0,1},{1,0,0,1},{1,1,1,1}};
		//		System.out.println(ls.largest(matrix));
		//		int[][] matrix = {{1}};
		//		LargestSubmatrixSum ls = new LargestSubmatrixSum();
		//		System.out.println(ls.largest(matrix));
		//		MinCutPalindrome m = new MinCutPalindrome();
		//		System.out.println(m.minCuts("abcbd"));
		//		LongestConsecutiveOnes lc = new LongestConsecutiveOnes();
		//		System.out.println(lc.longest(new int[]{1,0,1,0,0,1,1,1,1,0}));
		//		int a = 1;
		//		int[] array = new int[2];
		//		array[0] = ++a;
		//		System.out.println(array[0]);
		//		CuttingWoodI cw = new CuttingWoodI();
		//		System.out.println(cw.minCost(new int[] {3,16,19,28,37,44,47,48,51,52,62}, 67));
		//		LongestCommonSubString ls = new LongestCommonSubString();
		//		System.out.println(ls.longestCommon("abcde", "cdf"));
		//		LongestSubSequence ls = new LongestSubSequence();
		//		System.out.println(ls.longest("abcde", "cbabdfe"));
		//		LongestAscendingSubSequence ls = new LongestAscendingSubSequence();
		//		System.out.println(ls.longest(new int[] {5, 2, 6, 3, 4, 7, 5}));
		//		IsMatch im = new IsMatch();
		//		System.out.println(im.isMatch("a", "a*"));
		//		MaxProductSubArray arr = new MaxProductSubArray();
		//		int[] nums = new int[] {-2,3,-2,4};
		//		System.out.println(arr.maxProduct(nums));
		//		CoinChange cc = new CoinChange();
		//		int[] coins = {2,5};
		//		System.out.println(cc.coinChange(coins, 3));
		//		OddEvenJump j = new OddEvenJump();
		//		int[] A = {1,2,3,2,1,4,4,5};
		//		System.out.println(j.oddEvenJumps(A));
		//		NumOfLongestIncreasingSubsequence ls = new NumOfLongestIncreasingSubsequence();
		//		System.out.println(ls.findNumberOfLIS(new int[] {1,3,5,4,7}));
		//		SplitArrayLargestSum sa = new SplitArrayLargestSum();
		//		System.out.println(sa.splitArray(new int[] {7,2,5,10,8}, 2));
		System.out.println(numberToWords(12345));
		
	}
	
	public static String convert(int num) {
		String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen"};
		String[] tenth = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		
		if (num < 20) {
            return lessThanTwenty[num] + " ";
        } else if (num < 100) {
            return tenth[num / 10] + " " + convert(num % 10);
        } else {
            return lessThanTwenty[num / 100] + " Hundred " + convert(num % 100);
        }
    }
	
	public static String numberToWords(int num) {
		String[] base = {"", "Thousand", "Million", "Billion"};
		if (num == 0) return "Zero";
        int i = 0; // record the index of current base
        String result = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                result = convert(num % 1000) + base[i] + " " + result;
            } 
            num /= 1000;
            i++;
        }
        return result.trim();
    }
}
