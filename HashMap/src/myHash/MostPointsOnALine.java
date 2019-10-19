package myHash;

import java.util.HashMap;
import java.util.Map;


public class MostPointsOnALine {
	public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int result = 1;
        for (int i = 0; i < points.length - 1; i++) {
            // key: <k,b>  value: number of points
            Map<Param, Integer> map = new HashMap<>(); 
            int countVertical = 1; // key: a where x = a  
            int duplicates = 0;
            int max = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) { 
                    duplicates++;
                } else if (points[i][0] == points[j][0]) {
                	countVertical++;
                	max = Math.max(max, countVertical);
                } else {
                    double k = ((double)(points[i][1] - points[j][1])) * 100.0 / (points[i][0] - points[j][0]);
                    double b = points[i][1] - k * points[i][0];
                    Param p = new Param(k, b);
                    Integer num = map.getOrDefault(p, 1);
                    max = Math.max(max, ++num);
                    map.put(p, num);
                }
            }
            result = Math.max(result, max + duplicates);
        }
        return result;
    }
    
    static class Param {
        double k, b;
        public Param(double k, double b) {
            this.k = k;
            this.b = b;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Param)) return false;
            Param other = (Param)obj;
            return this.k == other.k && this.b == other.b;
        }
        
        @Override
        public int hashCode() {
            return (int)(31 * k + b);
        }
    }

}
