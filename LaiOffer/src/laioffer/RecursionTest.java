package laioffer;

public class RecursionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = power(0,4);
		System.out.println(result);
	}
	
	public static int power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		int half = power(a, b/2);
		return b%2==0 ? half*half : a*half*half;
	}

}
