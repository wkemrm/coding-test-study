import java.util.*;

class Solution {
    static String abc = "abcdefghijklmnopqrstuvwxyz";
    public String solution(long n, String[] bans) {
        
        // 알파벳을 26개
        // 1자리수 -> 26개
        // 2자리수 -> 26 * 26
        // 3자리수 -> 26 * 26 * 26
        Arrays.sort(bans, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        long find = n - 1;
        for (int i = 0 ; i < bans.length ; i++) {
            long num = strToLong(bans[i]);
            if (num <= find) {
                find++;
            }
        }
        return longToString(find);
    }
    
    public long strToLong(String str) {
        int len = str.length();
        long num = 0;
        
        for (int i = 0 ; i < len ; i++) {
            int idx = 0;
            for (int j = 0 ; j < abc.length() ; j++) {
                if (abc.charAt(j) == str.charAt(i)) {
                    idx = j + 1;
                    break;
                }
            }
            
            if (i == len - 1) {
                num += idx;
            } else {
                num += Math.pow(26, len - i - 1) * idx;
            }
            
        }
        return num - 1;
    }
    
    public String longToString(long result) {
        if (result >= 0 && result < 26) {
            return String.valueOf(abc.charAt((int) result));
        } else {
            return longToString(result / 26 - 1) + longToString(result % 26); 
        }
    }
}