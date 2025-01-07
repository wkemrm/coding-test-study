import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] graph;
    static int[] extent;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0 , 1, 0, -1};

    public static void DFS(int x, int y, int paint) {
        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == 1) {
                extent[paint] += 1;
                graph[nx][ny] = 0;
                DFS(nx, ny, paint);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        extent = new int[n * n];

        for (int i = 0 ; i < n ; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0 ; j < n ; j++) {
                graph[i][j] = Character.getNumericValue(input[j]);
            }
        }

        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (graph[i][j] == 1) {
                    count++;
                    extent[count] += 1;
                    graph[i][j] = 0;
                    DFS(i, j, count);
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1 ; i <= count ; i++) {
            pq.offer(extent[i]);
        }

        System.out.println(count);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}