import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solution();
    }
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public static void solution() {
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (graph[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    dis[i][j] = 1;
                } else if(graph[i][j] == -1) {
                    dis[i][j] = -1;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            int cd = dis[cx][cy];
            q.poll();
            
            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] 
                    && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    dis[nx][ny] = cd + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (dis[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                if (dis[i][j] == -1) continue;
                result = Math.max(dis[i][j], result);
            }
        }
        
        System.out.print(result - 1);
    }
}