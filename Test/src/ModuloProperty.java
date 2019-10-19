
public class ModuloProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//reminderIsOne(8);
		divisor(511);
		
		
	}
	
	public static void reminderIsOne(int n) {
		for (int i = 1; i < n; i++) {
			if (Math.pow(i,n-1) % n == 1) {
				System.out.println(i+"^"+(n-1)+" % "+ n +" is 1");
			} else {
				System.out.println("Failed!");
			}
		}
	}
	
	public static void divisor(int n) {
		for (int i = 1; i*i<=n; i++) {
			if (n%i == 0) {
				System.out.println(i);
			}
		}
	}

}
