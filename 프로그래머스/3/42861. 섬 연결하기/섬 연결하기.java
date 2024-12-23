import java.util.*;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;
    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
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
        if (fa != fb) unf[fa] = fb;
    }
    
    public int solution(int n, int[][] costs) {
        unf = new int[n];
        for (int i = 0 ; i < n ; i++) {
            unf[i] = i;
        }
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0 ; i < costs.length ; i++) {
            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int cost = costs[i][2];
            list.add(new Edge(v1, v2, cost));
        }
        
        Collections.sort(list);
        int answer = 0;
        for (int i = 0 ; i < list.size() ; i++) {
            Edge edge = list.get(i);
            int f1 = find(edge.v1);
            int f2 = find(edge.v2);
            if (f1 != f2) {
                answer += edge.cost;
                union(f1, f2);
            }
        }
        return answer;
    }
}