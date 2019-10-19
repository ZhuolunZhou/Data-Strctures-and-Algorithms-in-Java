package laiOffer;

public class Maze {
	public int[][] maze(int n) {
		int[][] maze = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = 1;
			}
		}
		maze[0][0] = 0;
		generate(maze, 0, 0);
		return maze;
	}

	private void generate(int[][] maze, int x, int y) {
		Direction[] dirs = Direction.values();
		shuffle(dirs);
		for (Direction dir : dirs) {
			int nextX = dir.moveX(x, 2);
			int nextY = dir.moveY(y, 2);
			if (isValid(maze, nextX, nextY)) {
				maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
				maze[nextX][nextY] = 0;
				generate(maze, nextX, nextY);
			}
		}
	}
	
	private void shuffle(Direction[] dirs) {
		for (int i = 0; i < dirs.length; i++) {
			int index = (int)(Math.random() * (dirs.length - i));
			Direction tmp = dirs[i];
			dirs[i] = dirs[i + index];
			dirs[i + index] = tmp;
		}
	}
	
	private boolean isValid(int[][] maze, int x, int y) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length &&
				maze[x][y] == 1;
	}
	
	enum Direction {
		UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0,1);
		int deltaX;
		int deltaY;

		Direction(int deltaX, int deltaY) {
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}

		public int moveX(int x, int times) {
			return x + times * deltaX;
		}

		public int moveY(int y, int times) {
			return y + times * deltaY;
		}
	}
}
