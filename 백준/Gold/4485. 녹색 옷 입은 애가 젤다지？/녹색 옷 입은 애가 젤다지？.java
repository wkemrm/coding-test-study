import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int order = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[][] input = new int[n][n];

            for (int i = 0 ; i < n ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < n ; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution(order, n, input);
            order++;
        }
    }

    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void solution(int order, int n, int[][] graph) {
        int[][] dist = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        dist[0][0] = graph[0][0];

        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] > dist[cx][cy] + graph[nx][ny]) {
                    dist[nx][ny] = dist[cx][cy] + graph[nx][ny];
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println("Problem " + order + ": " + dist[n - 1][n - 1]);
    }
}