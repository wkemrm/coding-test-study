import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }
        board = new int[n + 1][m + 1];
        for (int i = 1 ; i <= n ; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1 ; j <= m ; j++) {
                board[i][j] = input[j - 1] - '0';
            }
        }

        System.out.println(BFS());
    }

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int BFS() {
        int[][][] dist = new int[n + 1][m + 1][2];
        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        visited[1][1][0] = true;
        dist[1][1][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int dx = now[0];
            int dy = now[1];
            int dCrash = now[2];

            for (int i = 0 ; i < 4 ; i++) {
                int nx = dx + move[i][0];
                int ny = dy + move[i][1];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

                if (board[nx][ny] == 1) {
                    if (dCrash == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        dist[nx][ny][1] = dist[dx][dy][dCrash] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                } else {
                    if (!visited[nx][ny][dCrash]) {
                        visited[nx][ny][dCrash] = true;
                        dist[nx][ny][dCrash] = dist[dx][dy][dCrash] + 1;
                        q.offer(new int[]{nx, ny, dCrash});
                    }
                }
            }
        }

        if (dist[n][m][0] == 0 && dist[n][m][1] == 0) return -1;
        if (dist[n][m][0] == 0) return dist[n][m][1];
        if (dist[n][m][1] == 0) return dist[n][m][0];
        return Math.min(dist[n][m][0], dist[n][m][1]);
    }
}