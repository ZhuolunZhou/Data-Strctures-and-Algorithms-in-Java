package heap;
import java.util.*;

public class MinCostHireKWorkers {
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		double[][] workers = new double[quality.length][2];
		for (int i = 0; i < quality.length; i++) {
			workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
		}
		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
		double res = Double.MAX_VALUE, qsum = 0;
		Queue<Double> maxHeap = new PriorityQueue<>(K, Collections.reverseOrder());
		for (double[] worker: workers) { // try all ratios
			System.out.println("ratio is " + worker[0]);
			System.out.println("quality is " + worker[1]);
			qsum += worker[1];
			maxHeap.offer(worker[1]);
			if (maxHeap.size() > K) {
				qsum -= maxHeap.poll();
			}
			if (maxHeap.size() == K) {
				double cur = qsum * worker[0];
				System.out.println("current total is " + cur);
				res = Math.min(res, cur);
			}
		}
		return res;
	}
}
