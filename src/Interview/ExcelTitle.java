package Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongyangyu on 12/20/14.
 */
public class ExcelTitle {
    public static String convertToTitle(int n) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 1; i <= 26; i ++) {
            char ch = (char)('A' + i - 1);
            map.put(i, new StringBuilder().append(ch).toString());
        }
        map.put(0, "");
        StringBuilder sb = new StringBuilder();
        while(n / 26 > 0) {
            if (n % 26 == 0) {
                sb.insert(0, map.get(26));
                n -= 26;
            } else {
                sb.insert(0, map.get(n % 26));
                n -= n % 26;
            }
            n /= 26;
        }
        sb.insert(0, map.get(n % 26));
        return sb.toString();
    }

    public static int titleToNumber(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 1; i <= 26; i ++) {
            char ch = (char)('A' + i - 1);
            map.put(new Character(ch), i);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            res = res * 26 + map.get(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1048));
        System.out.println(titleToNumber("AB"));
    }
}