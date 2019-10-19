package laiOffer;
import java.util.*;

public class MissingRange {
//	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//		List<String> result = new ArrayList<String>();
//        long pre = (long)lower - 1;
//        for (int i = 0 ; i <= nums.length; i++){
//            long after = i == nums.length ? (long)upper + 1 : nums[i]; 
//            if (pre + 2 == after){
//                result.add(String.valueOf(pre + 1));
//            } else if(pre + 2 < after){
//                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
//            }
//            pre = after;
//        }
//        return result;    
//	}
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
	    for (int i = 0; i <= nums.length; i++) {
	        long start = i == 0 ? lower : (long)nums[i - 1] + 1;
	        long end = i == nums.length ? upper : (long)nums[i] - 1;
	        if (start > end) {
	            continue;
	        } else if (start == end) {
	            result.add(String.valueOf(start));
	        } else {
	            result.add(start + "->" + end);
	        }
	    }
	    return result;
	}
}
