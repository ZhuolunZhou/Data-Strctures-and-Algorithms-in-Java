package dataStrucure;

public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = new int[2][2];
		data[0][0] = 1;
		data[0][1] = 2;
		data[1][0] = 3;
		data[1][1] = 4;
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				System.out.print(data[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}

}
