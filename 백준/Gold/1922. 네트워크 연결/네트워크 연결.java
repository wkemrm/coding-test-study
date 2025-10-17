import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static Edge[] edges;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new Edge[m];
        parent = new int[n + 1];
        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, cost);
        }
        
        System.out.print(kruskal());
    } 
    
    public static int kruskal() {
        
        for (int i = 0 ; i <= n ; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(edges);
        int cost = 0;
        int count = 0;
        for (int i = 0 ; i < m ; i++) {
            Edge edge = edges[i];
            int fa = find(edge.a);
            int fb = find(edge.b);
            if (fa != fb) {
                union(fa, fb);
                cost += edge.cost;
                count++;
            }
            if (count == n - 1) {
                break;
            }
        }
        
        return cost;
    }
    
    public static int find(int input) {
        if (parent[input] == input){
            return input;
        }
        
        return parent[input] = find(parent[input]);
    }
    
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if (fa < fb) {
            parent[fb] = fa;
        } else {
            parent[fa] = fb;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;
        
        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}