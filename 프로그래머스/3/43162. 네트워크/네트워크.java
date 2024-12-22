import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    boolean[] visited;
    public void DFS(int v) {
        ArrayList<Integer> next = list.get(v);
        for (int i = 0 ; i < next.size() ; i++) {
            int nv = next.get(i);
            if (visited[nv] == false) {
                visited[nv] = true;
                DFS(nv);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0 ; i < computers.length ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i != j && computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0 ; i < list.size() ; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                answer++;
                DFS(i);
            }
        }
        return answer;
    }
}