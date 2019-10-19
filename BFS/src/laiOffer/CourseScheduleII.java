package laiOffer;
import java.util.*;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		// corner case
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				result[i] = i;
			}
			return result;
		}
		// indegree[i] denotes number of courses that course i depends on
		int[] indegree = new int[numCourses];  
		// outdegree[i] denotes a list of courses that depend on course i
		List<Integer>[] outdegree = new ArrayList[numCourses];
		// pre-processing, construct graph
		for (int[] i : prerequisites) {
			int course = i[0];
			int dependCourse = i[1];
			indegree[course]++;
			if (outdegree[dependCourse] == null) {
				outdegree[dependCourse] = new ArrayList<>();
			}
			outdegree[dependCourse].add(course);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		// put first level into queue
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int count = 0; // count number of completed courses
		int pointer = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			result[pointer++] = course;
			if (outdegree[course] == null) continue;
			for (int i : outdegree[course]) {
				if (--indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}
		return count == numCourses ? result : new int[0];
	}
}
