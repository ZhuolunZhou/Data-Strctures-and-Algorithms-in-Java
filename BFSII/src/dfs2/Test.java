package dfs2;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		DijkstraII dj = new DijkstraII();
		char[][] gym = new char[][]{{'C','C','E','O','C' }, {'C','C','O','C','E'}, {'C','C','E','E','C'},
			                       {'C','O','C','E','E'},{'C','C','O','C','C'}};
		List<Integer> result = dj.putChair(gym);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
