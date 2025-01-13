import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.print(result);
    }

    public static void DFS(int depth) {
        if (depth == 3) {
            BFS();
        } else {
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0; j < m ; j++) {
                    if (graph[i][j] == 0) {
                        graph[i][j] = 1;
                        DFS(depth + 1);
                        graph[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void BFS() {
        int[][] copyGraph = new int[n][m];
        Queue<int[]> q = new LinkedList<int[]>();

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                copyGraph[i][j] = graph[i][j];
                if (graph[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }


        while(!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && copyGraph[nx][ny] == 0) {
                    copyGraph[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (copyGraph[i][j] == 0) count++;
            }
        }

        result = Math.max(result, count);
    }
}