package heap;
import java.util.*;

public class SkyLine {
	public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> height = new ArrayList<>();
        for (int[] i : buildings) {
            height.add(Arrays.asList(i[0], -i[2])); // negative height denotes start point
            height.add(Arrays.asList(i[1], i[2])); // positive height denotes end point
        }
        // x equals has 3 cases
        // case 1 : both are start point -> need to add larger height first
        // case 2 : both are end point -> need to add smaller height first
        // case 3 : one start one end -> need to add larger height first
        // to do that, we make start point height negative, end point height positive
        height.sort((a,b) -> a.get(0).equals(b.get(0)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        
        // Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // maxHeap.offer(0);
        map.put(0, 0);
        int preHeight = 0;
        for (List<Integer> h : height) {
            if (h.get(1) < 0) { // start point
                //maxHeap.offer(-h.get(1));
                map.put(-h.get(1), map.getOrDefault(-h.get(1), 0) + 1);
            } else {
                //maxHeap.remove(h.get(1));
                Integer count = map.get(h.get(1));
                if (count == 1) {
                    map.remove(h.get(1));
                } else {
                    map.put(h.get(1), count - 1);
                }
                
            }
            // if (maxHeap.peek() != preHeight) {
            //     result.add(Arrays.asList(h.get(0), maxHeap.peek()));
            //     preHeight = maxHeap.peek();
            // }
            if (map.lastKey() != preHeight) {
                result.add(Arrays.asList(h.get(0), map.lastKey()));
                preHeight = map.lastKey();
            }
        }
        return result;
    }
}
