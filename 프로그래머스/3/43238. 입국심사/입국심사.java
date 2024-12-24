import java.util.*;

class Solution {
    public long ava(int[] times, long mid, long n) {
        long people = 0;
        for (int i = 0 ; i < times.length ; i++) {
            people += mid / times[i];
            if (people >= n) break;
        }
        
        return people;
    }
    
    public long solution(long n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long lt = 1l;
        long rt = (long) times[times.length - 1] * n;
        
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (ava(times, mid, n) >= n) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
}