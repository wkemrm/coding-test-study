import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0 ; i < fares.length ; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            graph.get(c).add(new Edge(d, f));
            graph.get(d).add(new Edge(c, f));
        }
        
        int[] aArr = dickstra(n, a, graph);
        int[] bArr = dickstra(n, b, graph);
        int[] sArr = dickstra(n, s, graph);
        
        int result = sArr[a] + sArr[b];
        
        for (int i = 1 ; i <= n ; i++) {
            if (i == s) continue;
            int sum = aArr[i] + bArr[i] + sArr[i];
            result = Math.min(result, sum);
        }
        // 각 위치에서 a까지 최소비용 + b까지 최소비용 + s에서 위치까지 최소 비용 min하면 될듯
        return result;
    }
    
    public int[] dickstra(int n, int start, List<List<Edge>> graph) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            int nowVex = now.vex;
            int nowCost = now.cost;
            if (nowCost > dis[nowVex]) continue;
            
            for (Edge next : graph.get(nowVex)) {
                if (dis[next.vex] > nowCost + next.cost) {
                    dis[next.vex] = nowCost + next.cost;
                    pq.offer(new Edge(next.vex, nowCost + next.cost));
                }
            }
        }
        
        return dis;
    }
    
    
    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;
        
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}