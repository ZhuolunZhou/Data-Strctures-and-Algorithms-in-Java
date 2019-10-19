package laiOffer;
import java.util.*;

public class AllFactors {
	public List<List<Integer>> combinations(int target) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (target <= 1) {
	      return result;
	    }    
	    List<Integer> factors = findFactors(target);
	    Collections.sort(factors);
	    List<Integer> cur = new ArrayList<>();
	    DFS(factors, 1, target, 0, cur, result);
	    return result;
	  }
	  
	  private void DFS(List<Integer> factors, int curProduct, int target, int index, List<Integer> cur,
	                   List<List<Integer>> result) {
	    if (curProduct == target) {
	      result.add(new ArrayList<Integer>(cur));
	      return;
	    } 
	    if (index == factors.size()) {
	      return;
	    }
	    int factor = factors.get(index);
	    int product = curProduct;
	    int idx = index;
	    // not counting current number
	    DFS(factors, curProduct, target, index + 1, cur, result); 
	    int i = 0;
	    while (product <= target) {
	      product *= factor;
	      i++;
	      for (int j = 0; j < i; j++) {
	        cur.add(factor);
	      }
	      DFS(factors, product, target, index + 1, cur, result);
	      for (int j = 0; j < i; j++) {
	        cur.remove(cur.size() - 1);
	      }
	    }
	  }
	  
	  private List<Integer> findFactors(int target) {
	    List<Integer> result = new ArrayList<>();
	    for (int i = 2; i * i <= target; i++) {
	      if (target % i == 0) {
	        if (i * i != target) {
	          result.add(i);
	        }
	        result.add(target / i);
	      }
	    }
	    return result;
	  }
}
