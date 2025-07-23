import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(max);
    }

    public static void DFS(int level) {
        if (level == 3) {
            solution();
        } else {
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < m ; j++) {
                    if (board[i][j] != 0) continue;

                    board[i][j] = 1;
                    DFS(level + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void solution() {
        int[][] copy = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                copy[i][j] = board[i][j];
                if (copy[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int dx = now[0];
            int dy = now[1];

            for (int i = 0 ; i < 4 ; i++) {
                int nx = dx + move[i][0];
                int ny = dy + move[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int result = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (copy[i][j] == 0) {
                    result++;
                }
            }
        }

        max = Math.max(result, max);
    }
}