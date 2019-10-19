package laioffer;
import java.util.*;

public class Class2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		sol.check();
	}

}

class Solution {
	public void check() {
		for (int i = 4; i < 10000; i+=2) {
			if (isCounterExample(i)) {
				System.out.print("Congrats");
				return;
			} else {
				System.out.println(i + " is not a counter-example.");
			}
		}
	}
	
	private boolean isCounterExample(int n) {
		for (int i = 2; i <= n/2; i++) {
			if (isPrime(i) && isPrime(n-i)) {
				return false; 
			}
		}
		return true;
	}
	
	private boolean isPrime(int n) {
		for (int i = 2; i*i <= n; i++) {
			if (n % i ==0) {
				return false;
			}
		}
		return true;
	}
}
