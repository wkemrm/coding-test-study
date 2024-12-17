import java.util.*;

class Edge implements Comparable<Edge>{
    int vex;
    int cost;
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}

class Solution {
    ArrayList<ArrayList<Edge>> graph;
    
    public int[] solution(int n, int v) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        dis[v] = 0;
        q.offer(new Edge(v, 0));
        
        while(!q.isEmpty()) {
            Edge tmp = q.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (visited[now]) {
                continue;
            }
            visited[now] = true;
            for (Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    q.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
        
        return dis;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<ArrayList<Edge>>();
        
        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<Edge>());
        }
        
        for (int i = 0 ; i < fares.length ; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            graph.get(start).add(new Edge(end, cost));
            graph.get(end).add(new Edge(start, cost));
        }
        int[] sd = solution(n, s);
        int[] ad = solution(n, a);
        int[] bd = solution(n, b);
        
        int result = Integer.MAX_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            int total = sd[i] + ad[i] + bd[i];
            result = Math.min(total, result);
        }
        return result;
    }
}