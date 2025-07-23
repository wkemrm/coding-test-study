import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    static long[][] dis;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new long[n][m];
        visited = new boolean[n][m];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long result = DFS(0, 0);

        System.out.println(result);
    }

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static long DFS(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (visited[x][y]) {
            return dis[x][y];
        }

        visited[x][y] = true;
        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[x][y] > board[nx][ny]) {
                dis[x][y] += DFS(nx, ny);
            }
        }

        return dis[x][y];
    }
}