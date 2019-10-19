package laiOffer;
import java.util.*;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        int max = 0;
        String tmp = "";
        for (String w : words) {
            if (!ban.contains(w)) {
                int freq = count.getOrDefault(w, 0) + 1;
                if (freq > max) {
                    max = freq;
                    tmp = w;
                }
                count.put(w, freq);
            }
        }
        return tmp;
	}
}
