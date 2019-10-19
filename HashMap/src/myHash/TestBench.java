package myHash;

import myHash.MyHashMap.Entry;

public class TestBench {

	public static void main(String[] args) {
//		MyHashMap<String, Integer> map = new MyHashMap<>(4, 0.5f);
//		map.put("yahoo", 1);
//		map.put("google", 2);
//		map.put("facebook", 3);
//		map.put("amazon", 4);
//		map.put("uber", 5);
//		for (MyHashMap.Entry<String, Integer> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}		
		MostPointsOnALine mp = new MostPointsOnALine();
//		int[][] points = new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//		int[][] points = new int[][] {{0,0},{0,0}};
//		int[][] points = new int[][] {{0,0},{1,1},{0,0}};
//		int[][] points = new int[][] {{0,0},{-1,-1},{2,2}};
		int[][] points = new int[][] {{0,0},{94911151,94911150},{94911152,94911151}};
		System.out.println(mp.maxPoints(points));
	}

}
