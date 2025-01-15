import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] graph;
    static int max_height = Integer.MIN_VALUE;

    public static boolean[][] getVisited(int height) {
        boolean[][] visited = new boolean[n][n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (graph[i][j] <= height) {
                    visited[i][j] = true;
                }
            }
        }

        return visited;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
                if (input > max_height) {
                    max_height = input;
                }
            }
        }

        int maxCount = Integer.MIN_VALUE;

        for (int height = 0 ; height <= max_height ; height++) {
            boolean[][] visited = getVisited(height);
            int count = 0;
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if (visited[i][j] == false) {
                        DFS(i, j, visited);
                        count++;
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.print(maxCount);
    }

    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, boolean[][] visited) {
        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny, visited);
            }
        }
    }
}