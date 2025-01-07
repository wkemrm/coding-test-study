import java.util.*;
import java.io.*;

class Main {
    static int m;
    static int n;
    static int k;
    static boolean[][] visited;
    static int[] extent;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, int paint) {
        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == false) {
                extent[paint] += 1;
                visited[nx][ny] = true;
                DFS(nx, ny, paint);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        extent = new int[n * m];
        k = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            for (int j = leftX ; j < rightX ; j++) {
                for (int l = leftY ; l < rightY ; l++) {
                    visited[j][l] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (visited[i][j] == false) {
                    count++;
                    visited[i][j] = true;
                    extent[count] += 1;
                    DFS(i, j, count);
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1 ; i <= count ; i++) {
            pq.offer(extent[i]);
        }

        System.out.println(count);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}