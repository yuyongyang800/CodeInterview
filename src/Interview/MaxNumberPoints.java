package Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongyangyu on 12/8/14.
 */
public class MaxNumberPoints {
    public int maxPoints(Point[] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int maxNum = 0;
        for (int i = 0; i < points.length; i ++) {
            map.clear();
            // set a default value
            map.put((double)Integer.MIN_VALUE, 0);
            int dup = 1;
            for (int j = 0; j < points.length; j ++) {
                if (j == i) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup ++;
                    continue;
                }
                double k = points[i].x == points[j].y ? (double)Integer.MAX_VALUE :
                        (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                }
                else {
                    map.put(k, 1);
                }
            }
            for (double d : map.keySet()) {
                if (map.get(d) + dup > maxNum) {
                    maxNum = map.get(d) + dup;
                }
            }
        }
        return maxNum;
    }

    class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }
        Point (int a, int b) {
            x = a;
            y = b;
        }
    }
}
