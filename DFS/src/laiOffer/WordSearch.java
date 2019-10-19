package laiOffer;
import java.util.*;

public class WordSearch {
//	public boolean isWord(char[][] board, String word) {
//		if (board == null || board.length == 0 || board[0].length == 0 ||
//				word == null || word.length() == 0) {
//			return false;
//		}
//		char start = word.charAt(0);
//		int N = board.length;
//		int M = board[0].length;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (board[i][j] == start) {   
//					StringBuilder sb = new StringBuilder();
//					Set<Cell> set = new HashSet<>();
//					sb.append(board[i][j]);
//					set.add(new Cell(i, j));
//					if (DFS(board, N, M, i, j, word, set, sb)) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	private boolean DFS(char[][] board, int N, int M, int row, int col, 
//			String word, Set<Cell> set, StringBuilder sb) {
//		
//		if (sb.length() == word.length()) {
//			return sb.toString().equals(word);
//		}
//
//		// up
//		if (row - 1 >= 0) {
//			Cell newCell = new Cell(row - 1, col);
//			if (set.add(newCell)) {
//				char c = board[row - 1][col];
//				sb.append(c);
//				if (DFS(board, N, M, row - 1, col, word, set, sb)) {
//					return true;
//				}
//				sb.deleteCharAt(sb.length() - 1);
//				set.remove(newCell);
//			}
//		}
//
//		// down
//		if (row + 1 < N) {
//			Cell newCell = new Cell(row + 1, col);
//			if (set.add(newCell)) {
//				char c = board[row + 1][col];
//				sb.append(c);
//				if (DFS(board, N, M, row + 1, col, word, set, sb)) {
//					return true;
//				}
//				sb.deleteCharAt(sb.length() - 1);
//				set.remove(newCell);
//			}
//		}
//
//		// left
//		if (col - 1 >= 0) {
//			Cell newCell = new Cell(row, col - 1);
//			if (set.add(newCell)) {
//				char c = board[row][col - 1];
//				sb.append(c);
//				if (DFS(board, N, M, row, col - 1, word, set, sb)) {
//					return true;
//				}
//				sb.deleteCharAt(sb.length() - 1);
//				set.remove(newCell);
//			}
//		}
//
//		// right
//		if (col + 1 < M) {
//			Cell newCell = new Cell(row, col + 1);
//			if (set.add(newCell)) {
//				char c = board[row][col + 1];
//				sb.append(c);
//				if (DFS(board, N, M, row, col + 1, word, set, sb)) {
//					return true;
//				}
//				sb.deleteCharAt(sb.length() - 1);
//				set.remove(newCell);
//			}
//		}
//		return false;
//	}
//
//	static class Cell {
//		int row;
//		int col;
//		public Cell(int row, int col) {
//			this.row = row;
//			this.col = col;
//		} 
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj) {
//				return true;
//			}
//			if (!(obj instanceof Cell)) {
//				return false;
//			}
//			Cell other = (Cell)obj;
//			return this.row == other.row && this.col == other.col;
//		}    
//		@Override
//		public int hashCode() {
//			return this.row * 31 + this.col;
//		}
//	}
	
	public boolean exist(char[][] board, String word, boolean[][] visited) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word, visited, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int row, int col, int index, String word, boolean[][] visited, int[][] dirs) {
        if (index == word.length() - 1 && board[row][col] == word.charAt(index)) {
            return true;
        } else if (board[row][col] != word.charAt(index)) {
            return false;
        } 
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                if (dfs(board, x, y, index + 1, word, visited, dirs)) {
                	return true;
                }
            }
        }
        visited[row][col] = false;
        return false;
    }
}
