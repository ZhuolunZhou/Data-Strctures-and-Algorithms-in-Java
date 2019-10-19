package laiOffer;
import java.util.*;

public class CourseSchedule {
	public boolean canFinish(int num, int[][] prerequisites) {
		// indegree[i] denotes number of courses that i depends on
		int[] indegree = new int[num];
		// outdegree[i] denotes a list of courses that depends on i
		List[] outdegree = new ArrayList[num];

		for (int i = 0; i < num; ++i ){
			outdegree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++){
			indegree[prerequisites[i][0]]++;
			outdegree[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		// bfs first level: indegree[i] == 0
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < num; i++){
			if(indegree[i] == 0 ){
				queue.offer(i);
			}
		}

		int res = 0;
		while(!queue.isEmpty()){
			int course = queue.poll();
			res++;
			for (int i = 0; i < outdegree[course].size(); i++){
				int nextCourse = (int) outdegree[course].get(i);
				if (--indegree[nextCourse] == 0){
					queue.offer(nextCourse);
				}
			}
		}
		return res == num;
	}
}
