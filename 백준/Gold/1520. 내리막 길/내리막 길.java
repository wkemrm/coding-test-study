import java.util.*;
import java.io.*;

class Main {
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n;
    static int m;
    static int[][] arr;
    static long[][] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dis = new long[n][m];
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dis[i][j] = -1;
            }
        }

        DFS(0, 0);

        System.out.println(dis[0][0]);
    }

    public static long DFS(int x, int y) {
        if (x == n - 1 && y == m - 1) return 1;
        if (dis[x][y] != -1) return dis[x][y];

        dis[x][y] = 0;

        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] < arr[x][y]) {
                dis[x][y] += DFS(nx, ny);
            }
        }

        return dis[x][y];
    }
}