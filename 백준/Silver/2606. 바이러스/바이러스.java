import java.util.*;
import java.io.*;

class Main {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        DFS(1);
        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            if (visited[i]) count++;
        }
        
        System.out.print(count - 1);
    }
    
    public static void DFS(int edge) {
        if (visited[edge]) return;
        
        visited[edge] = true;
        for (int next : graph.get(edge)) {
            DFS(next);
        }
    }
}