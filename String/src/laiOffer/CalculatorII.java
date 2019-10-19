package laiOffer;
import java.util.*;

public class CalculatorII {
	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		Deque<Integer> stack = new ArrayDeque<>();
		s += '+'; // need to push last number into stack
		char operator = '+'; // need to push first element into stack
		int curNum = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') continue;
			if (Character.isDigit(c)) { 
				curNum = curNum * 10 + (c - '0'); 
				continue; 
			}
			if (operator == '+') {
				stack.offerFirst(curNum);
			} else if (operator == '-') {
				stack.offerFirst(-curNum);
			} else if (operator == '*') {
				stack.offerFirst(stack.pollFirst() * curNum);	
			} else if (operator == '/') {
				stack.offerFirst(stack.pollFirst() / curNum);
			}
			operator = c;
			curNum = 0;
		}

		int total = 0;
		while (!stack.isEmpty()) total += stack.pollFirst();
		return total;
	}
}
