package laiOffer;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					count++;
					visited[i][j] = true;
					dfs(grid, i, j, visited, dirs);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int row, int col, boolean[][] visited, int[][] dirs) {
		for (int[] dir : dirs) {
			int x = row + dir[0];
			int y = col + dir[1];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited[x][y]) {
				visited[x][y] = true;
				dfs(grid, x, y, visited, dirs);
			}
		}
	}
}
