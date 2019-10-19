package laiOffer;
import java.util.*;

public class LongestSubStringI {	
	public int lengthOfLongestSubstring(String s) {
        // time: O(n) on average  space: O(n)
        if (s == null || s.length() == 0) return 0;
        // key: visited character   value: corresponding index
        Map<Character, Integer> map = new HashMap<>(); 
        int left = 0, longest = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            Integer idx = map.get(c);
            if (idx != null) { // has repeated in current substring
                // make sure index is within current substr
                left = Math.max(left, idx + 1); 
            }    
            map.put(c, right);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
