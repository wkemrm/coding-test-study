import java.util.*;
import java.io.*;

class Main {
    static int r;
    static int c;
    static int[][] map;
    static int[][] totalDis;
    static List<Point> pointList;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            if (r == 0 && c == 0) {
                break;
            }
            map = new int[r][c];
            pointList = new ArrayList<>();
            result = Integer.MAX_VALUE;
            for (int i = 0 ; i < r ; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0 ; j < c ; j++) {
                    map[i][j] = input[j];
                    if (map[i][j] == 'o') {
                        pointList.add(0, new Point(i, j));
                    } else if(map[i][j] == '*') {
                        pointList.add(new Point(i, j));
                    }
                }
            }
            totalDis = new int[pointList.size()][pointList.size()];


            for (int i = 0 ; i < pointList.size() ; i++) {
                BFS(i, pointList.get(i));
            }
            visited = new boolean[pointList.size()];
            visited[0] = true;
            DFS(0, 0, 0);

            if (result == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(result);
            }
        }
    }

    public static void DFS(int index, int depth, int sum) {
        if (depth == pointList.size() - 1) {
            result = Math.min(result, sum);
        } else {
            for (int i = 0 ; i < totalDis.length ; i++) {
                if (visited[i] || totalDis[index][i] == 0) continue;
                visited[i] = true;
                DFS(i, depth + 1, sum + totalDis[index][i]);
                visited[i] = false;
            }
        }
    }
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void BFS(int index, Point start) {
        boolean[][] visited = new boolean[r][c];
        int[][] dis = new int[r][c];

        Queue<int[]> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.add(new int[]{start.x, start.y});

        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && map[nx][ny] != 'x') {
                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0 ; i < pointList.size() ; i++) {
            if (i == index) continue;
            Point point = pointList.get(i);
            totalDis[index][i] = dis[point.x][point.y];
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}