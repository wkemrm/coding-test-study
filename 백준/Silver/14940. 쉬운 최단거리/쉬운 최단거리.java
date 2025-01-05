import java.util.*;
import java.io.*;

class Edge {
    int x;
    int y;
    int cost;
    
    public Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[][] result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];
        
        Queue<Edge> q = new LinkedList<Edge>();
  
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                int state = Integer.parseInt(st.nextToken());
                graph[i][j] = state;
                if (state == 2) {
                    q.offer(new Edge(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Edge edge = q.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = edge.x + dx[i];
                int ny = edge.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Edge(nx, ny, edge.cost + 1));
                    result[nx][ny] = edge.cost + 1;
                }
            }
        }
        
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (visited[i][j] == false && graph[i][j] == 1) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(result[i][j] + " ");
                }
                
            }
            System.out.println();
        }
    }
}