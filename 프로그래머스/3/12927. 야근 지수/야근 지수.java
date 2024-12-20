import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0 ; i < n ; i++) {
            if (!pq.isEmpty()) {
                int su = pq.poll() - 1;
                if (su > 0) {
                  pq.offer(su);
                }
            }
        }
        long total = 0;
        while (!pq.isEmpty()) {
            int su = pq.poll();
            total += (long)su * (long)su;
        }
        return total;
    }
}