package laiOffer;

public class Atoi {
//	public int atoi(String str) {
//		// handle null and empty string
//		if (str == null || str.length() == 0) {
//			return 0;
//		}
//		long result = 0;
//		boolean positive = true;
//		boolean seen = false;
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if (!seen && (c == ' '|| c == '\t')) { // handle leading spaces and tab
//				continue;
//			} else if (seen && (c < '0' || c > '9')) {
//				break;
//			} else if (c == '+' || c == '-') { // handle signs
//				positive = c == '+';
//			} else if (c >= '0' && c <= '9') {
//				seen = true;
//				result = result * 10 + (c - '0');
//				if (positive && result > (long)Integer.MAX_VALUE) {
//					return Integer.MAX_VALUE;
//				} else if (!positive && result > (long)Integer.MAX_VALUE + 1) {
//					return Integer.MIN_VALUE;
//				}
//			} 
//		}
//		return positive ? (int)result : (int)-result;
//	}
	
	public int myAtoi(String str) {
        // 1. remove leading spaces
        // 2. optional sign
        // 3. discard other characters after numerical digits
        // 4. if no valid sol, return 0
        // 5. if out of range, return Integer.MIN_VALUE or Integer.MAX_VALUE
        
        // corner case
        if (str == null || str.length() == 0) return 0;
        boolean seen = false;
        int sign = 1;
        long cur = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && !seen) {
                continue;
            }
            if ((c == '+' || c == '-' ) && !seen) {
                sign = c == '+' ? 1 : -1;
                seen = true;
                continue;
            }
            if (Character.isDigit(c)) {
                seen = true;
                cur = cur * 10 + (c - '0');
                if (cur > (long)Integer.MAX_VALUE + 1) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            } 
        }
        if (cur == (long)Integer.MAX_VALUE + 1 && sign == 1) {
            return Integer.MAX_VALUE;
        }
        return (int) (sign * cur);
    }
}


