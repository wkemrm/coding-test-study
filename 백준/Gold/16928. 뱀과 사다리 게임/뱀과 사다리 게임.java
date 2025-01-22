import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] graph = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= 100 ; i++) {
            graph[i] = i;
        }

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start] = end;
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start] = end;
        }

        System.out.println(BFS(1));
    }

    public static int BFS(int start) {
        int[] dis = new int[101];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dis[start] = 0;

        int result = Integer.MAX_VALUE;
        boolean flag = false;
        while (!q.isEmpty() && !flag) {
            int now = q.poll();

            for (int i = 1 ; i < 7 ; i++) {
                int next = now + i;

                if (next > 100) {
                    continue;
                }

                if (dis[graph[next]] == 0) {
                    q.offer(graph[next]);
                    dis[graph[next]] = dis[graph[now]] + 1;
                }

                if (graph[next] == 100) {
                    result = dis[graph[next]];
                    flag = true;
                }
            }
        }

        return result;
    }
}