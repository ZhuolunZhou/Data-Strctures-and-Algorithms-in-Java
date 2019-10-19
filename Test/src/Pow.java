
public class Pow {
	public double myPow(double x, int n) {
        if (x == 0 && n <= 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }
    
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } 
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
