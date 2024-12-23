import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0 ; i < B.length ; i++) {
            q.offer(B[i]);
        }
        for (int i = 0 ; i < A.length ; i++) {
            while(!q.isEmpty()) {
                int min = q.poll();
                if (min > A[i]) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}