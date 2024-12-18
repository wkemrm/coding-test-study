import java.util.*;
import java.util.stream.*;

class Solution {
    int[] cost;
    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
    public void dir(int v) {
        Queue<Integer> q = new LinkedList<>();
        cost[v] = 0;
        q.offer(v);
        
        while (!q.isEmpty()) {
            int vex = q.poll();
            
            if (visited[vex]) {
                continue;
            }
            visited[vex] = true;
            
            for (int nv : graph.get(vex)) {
                if (cost[nv] > cost[vex] + 1 && !visited[nv]) {
                    cost[nv] = cost[vex] + 1;
                    q.offer(nv);
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        visited = new boolean[n+1];
        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0 ; i < edge.length ; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        dir(1);
        cost[0] = 0;
        List<Integer> result = Arrays.stream(cost)
            .boxed()
            .collect(Collectors.toList());
        int count = Collections.frequency(result, Collections.max(result));
        return count;
    }
}