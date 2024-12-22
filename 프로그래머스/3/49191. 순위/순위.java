import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> wins = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> loses = new ArrayList<ArrayList<Integer>>();
        int answer = 0;
        for (int i = 0 ; i <= n ; i++) {
            wins.add(new ArrayList<Integer>());
            loses.add(new ArrayList<Integer>());
        }
        
        for (int i = 0 ; i < results.length ; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            wins.get(win).add(lose);
            loses.get(lose).add(win);
        }
        
        for (int i = 1 ; i <= n ; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            visited[i] = true;
            q.offer(i);
            
            while(!q.isEmpty()) {
                int win = q.poll();
                for (int lose : wins.get(win)) {
                    if (visited[lose] == false) {
                        visited[lose] = true;
                        q.offer(lose);
                    }
                }
            }
            
            q.offer(i);
            
            while(!q.isEmpty()) {
                int lose = q.poll();
                for (int win : loses.get(lose)) {
                    if (visited[win] == false) {
                        visited[win] = true;
                        q.offer(win);
                    }
                }
            }
            
            boolean flag = true;
            for (int k = 1 ; k <= n ; k++) {
                if (visited[k] == false) {
                    flag = false;
                    break;
                } 
            }
            
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}