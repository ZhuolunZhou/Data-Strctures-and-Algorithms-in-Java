package laioffer;

public class MultiplyString {
	public String multiply(String num1, String num2) {
        long n1 = convertToLong(num1);
        long n2 = convertToLong(num2);
        long n3 = n1 * n2;
        if (n3 == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n3 > 0) {
            sb.insert(0, n3 % 10);
            n3 /= 10;
        }
        return sb.toString();
    }
    
    private long convertToLong(String s) {
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }
}
