package trie;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		System.out.println(strechy("hello", "heeellooo")); 
		int[] quality = {10,20,5};
		int[] wage = {70,50,30};
		double[][] workers = new double[quality.length][2];
		for (int i = 0; i < quality.length; i++) {
			workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
		}
		Arrays.sort(workers, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });
		for (int i = 0; i < workers.length; i++) {
			System.out.println(workers[i][0]);
		}
	}
	
	private static boolean strechy(String word, String target) {
        int pWord = 0, pTarget = 0;
        while (pWord < word.length() && pTarget < target.length()) {
            char w = word.charAt(pWord);
            char t = target.charAt(pTarget);
            if (w != t) return false;
            int cWord = 0;
            while (pWord < word.length() && word.charAt(pWord) == w) {
                cWord++;
                pWord++;
            }
            int cTarget = 0;
            while (pTarget < target.length() && target.charAt(pTarget) == t) {
                cTarget++;
                pTarget++;
            }
            if (cWord == cTarget || cTarget >= 3 && cWord < cTarget) continue;
            return false;
        }
        return pWord == word.length() && pTarget == target.length();
    }

}
