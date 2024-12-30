import java.util.*;

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int cost;
    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

class Solution {
    int[] unf;
    public int find(int v) {
        if (unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }
    
    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
    
    public int solution(int n, int[][] costs) {
        unf = new int[n];
        for (int i = 0 ; i < n ; i++) {
            unf[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0 ; i < costs.length ; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            pq.offer(new Edge(a, b, cost));
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int fa = find(edge.a);
            int fb = find(edge.b);
            if(fa != fb) {
                answer+= edge.cost;
                union(fa, fb);
            }
        }
        return answer;
    }
}