import java.util.*;
import java.io.*;

class Main {
    static char[][][] graph;
    static int[][][] dis;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int l;
    static int r;
    static int c;
    static int startH;
    static int startX;
    static int startY;
    static int endH;
    static int endX;
    static int endY;
    public static void BFS() {
        Queue<int[]> q = new LinkedList<>();

        boolean[][][] visited = new boolean[l][r][c];

        for (int h = 0 ; h < l ; h++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    dis[h][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        q.offer(new int[]{startH, startX, startY});
        visited[startH][startX][startY] = true;
        dis[startH][startX][startY] = 0;
        while(!q.isEmpty()) {
            int curH = q.peek()[0];
            int curX = q.peek()[1];
            int curY = q.peek()[2];
            q.poll();
            for (int i = 0 ; i < 6 ; i++) {
                int nh = curH + dh[i];
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nh >= 0 && nh < l && nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nh][nx][ny] && (graph[nh][nx][ny] == '.' || graph[nh][nx][ny] == 'E')) {
                    visited[nh][nx][ny] = true;
                    dis[nh][nx][ny] = Math.min(dis[nh][nx][ny], dis[curH][curX][curY] + 1);
                    q.offer(new int[]{nh, nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            graph = new char[l][r][c];
            dis = new int[l][r][c];
            for (int h = 0 ; h < l ; h++) {
                for (int i = 0 ; i < r ; i++) {
                    char[] input = br.readLine().toCharArray();
                    for (int j = 0 ; j < c ; j++) {
                        if(input[j] == 'S') {
                            startH = h;
                            startX = i;
                            startY = j;
                        }

                        if(input[j] == 'E') {
                            endH = h;
                            endX = i;
                            endY = j;
                        }
                        graph[h][i][j] = input[j];
                    }
                }
                br.readLine();
            }
            BFS();
            if (dis[endH][endX][endY] == Integer.MAX_VALUE) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + dis[endH][endX][endY] + " minute(s).");
            }
        }

    }
}