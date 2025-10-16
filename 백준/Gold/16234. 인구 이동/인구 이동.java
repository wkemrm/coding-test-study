import java.util.*;
import java.io.*;

public class Main {
    static int n, l, r;
    static int[][] board;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j, visited);
                        if (union.size() > 1) {
                            moved = true;
                            int sum = 0;
                            for (int[] pos : union) sum += board[pos[0]][pos[1]];
                            int avg = sum / union.size();
                            for (int[] pos : union) board[pos[0]][pos[1]] = avg;
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static List<int[]> bfs(int x, int y, boolean[][] visited) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        union.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int dx = now[0];
            int dy = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = dx + move[i][0];
                int ny = dy + move[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(board[dx][dy] - board[nx][ny]);
                    if (diff >= l && diff <= r) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return union;
    }
}
