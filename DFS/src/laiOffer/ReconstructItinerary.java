package laiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
	public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        int num = tickets.size();
        for (List<String> ticket : tickets) {
            List<String> arrivals = map.getOrDefault(ticket.get(0), new ArrayList<>());
            arrivals.add(ticket.get(1));
            map.put(ticket.get(0), arrivals);
        }
        for (List<String> arrival : map.values()) {
        	Collections.sort(arrival);
        }
        result.add("JFK");
        if (dfs(map, num, "JFK", result)) {
        	return result;
        }
        return null;
    }
    
    private boolean dfs(Map<String, List<String>> map, int remain, String departure, List<String> result) {
        if (remain == 0) return true;
        if (!map.containsKey(departure)) return false;
        List<String> arrivals = map.get(departure);
        
        for (int i = 0; i < arrivals.size(); i++) {
        	String arrival = arrivals.get(i);
        	arrivals.remove(i);
        	result.add(arrival);
        	if (dfs(map, remain - 1, arrival, result)) {
            	return true;
            }
        	arrivals.add(i, arrival);
        	result.remove(result.size() - 1);
        }
        return false;
    }
}
