package laiOffer;

public class PrintIfStatement {
	public void printBlocks(int n) {
		char[] array = new char[2 * n];
		combinations(n, n, array, 0);
		
	}
	
	private void combinations(int left, int right, char[] array, int index) {
		if (left == 0 && right == 0) {
			printSolution(array);
			return;
		}
		if (left > 0) {
			array[index] = '{';
			combinations(left - 1, right, array, index + 1);
		}
		if (right < left) {
			array[index] = '}';
			combinations(left, right - 1, array, index + 1);
		}
	}
	
	private void printSolution(char[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '{') {
				for (int j = 0; j < count; j++) {
					System.out.print(" ");
				}
				System.out.println("if {");
				count += 2;
			} else {
				count -= 2;
				for (int j = 0; j < count; j++) {
					System.out.print(" ");
				}
				System.out.println("}");
			}
		}
	}
}
