package leetcode;

public class Test {
	public static void main(String[] args) {
		MostStonesRemoved ms = new MostStonesRemoved();
		int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println(ms.removeStones(stones));
	}
}


