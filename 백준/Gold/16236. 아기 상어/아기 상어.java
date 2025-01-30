import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] graph;
    static int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static PriorityQueue<Shark> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        Queue<Shark> q = new LinkedList<>();
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 9) {
                    graph[i][j] = 0;
                    q.offer(new Shark(i, j, 0));
                } else {
                    graph[i][j] = input;
                }
            }
        }

        BFS(q, 2);

        int move = 0;
        int eat = 0;
        int size = 2;

        while (!pq.isEmpty()) {
            Shark now = pq.poll();
            graph[now.x][now.y] = 0;
            move += now.dis;
            eat++;
            if (eat == size) {
                eat = 0;
                size++;
            }
            q = new LinkedList<>();

            q.offer(new Shark(now.x, now.y, 0));
            BFS(q, size);
        }
        System.out.println(move);
    }

    public static void BFS(Queue<Shark> q, int size) {
        pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        while(!q.isEmpty()) {
            Shark now = q.poll();

            for (int i = 0; i < 4 ; i++) {
                int nx = now.x + direction[i][0];
                int ny = now.y + direction[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || graph[nx][ny] > size) continue;

                visited[nx][ny] = true;
                q.offer(new Shark(nx, ny, now.dis + 1));
                if (graph[nx][ny] > 0 && graph[nx][ny] < size) {
                    pq.offer(new Shark(nx, ny, now.dis + 1));
                }
            }
        }
    }

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int dis;

        public Shark(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public int compareTo(Shark shark) {
            if (this.dis != shark.dis) {
                return this.dis - shark.dis;
            } else {
                if (this.x != shark.x) {
                    return this.x - shark.x;
                }
                return this.y - shark.y;
            }
        }
    }
}