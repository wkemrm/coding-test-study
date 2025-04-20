import java.util.*;
import java.io.*;

class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] map;
    static List<Point> virusList = new ArrayList<Point>();
    static int result = Integer.MAX_VALUE;
    static Point[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        select = new Point[m];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        DFS(0, 0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    public static void DFS(int cnt, int start) {
        if (cnt == m) {
            BFS();
        } else {
            for (int i = start ; i < virusList.size() ; i++) {
                Point virus = virusList.get(i);
                select[cnt] = new Point(virus.x, virus.y);
                DFS(cnt + 1, i + 1);
            }
        }
    }

    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void BFS() {
        int[][] copy = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                int cur = map[i][j];
                if (cur == 0 || cur == 2) {
                    copy[i][j] = -1;
                } else {
                    copy[i][j] = -2;
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0 ; i < m ; i++) {
            Point virus = select[i];
            q.offer(virus);
            visited[virus.x][virus.y] = true;
            copy[virus.x][virus.y] = 0;
        }

        while(!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int nx = now.x + direction[i][0];
                int ny = now.y + direction[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && copy[nx][ny] == -1) {
                    visited[nx][ny] = true;
                    copy[nx][ny] = copy[now.x][now.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (copy[i][j] == -1) {
                    return;
                }
                max = Math.max(max, copy[i][j]);
            }
        }

        result = Math.min(max, result);
    }
}