import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;
    static Point[] points;
    static boolean[] pointVisited;

    public static void BFS() {
        int[][] dis = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        // init
        for (int i = 0 ; i < pointVisited.length ; i++) {
            if (pointVisited[i] == true) {
                q.offer(new int[]{points[i].x, points[i].y});
                visited[points[i].x][points[i].y] = true;
            }
        }

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && (graph[nx][ny] == 0 || graph[nx][ny] == 2)) {
                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[curX][curY] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int time = Integer.MIN_VALUE;

        boolean full = true;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if ((graph[i][j] == 0 || graph[i][j] == 2) && visited[i][j] == false) {
                    full = false;
                }
            }
        }

        if (full) {
            flag = true;
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if (graph[i][j] == 0 || graph[i][j] == 2) {
                        time = Math.max(dis[i][j], time);
                    }
                }
            }
            min = Math.min(time, min);
        }
    }

    public static void DFS(int depth, int x) {
        if (depth == m) {
            BFS();
        } else {
            for (int i = x ; i < points.length ; i++) {
                pointVisited[i] = true;
                DFS(depth + 1, i + 1);
                pointVisited[i] = false;
            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        List<Point> pointList = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
                if (input == 2) {
                    pointList.add(new Point(i, j));
                }
            }
        }

        points = new Point[pointList.size()];
        pointVisited = new boolean[pointList.size()];

        for (int i = 0 ; i < pointList.size() ; i++) {
            points[i] = pointList.get(i);
        }

        DFS(0, 0);

        if (flag) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}