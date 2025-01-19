import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int k;
    static int[] dis = new int[100001];

    public static int next(int i, int su) {
        if (i == 0) {
            return su + 1;
        } else if (i == 1) {
            return su -1;
        } else {
            return su * 2;
        }
    }

    public static void BFS() {
        Arrays.fill(dis, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        dis[n] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0 ; i < 3 ; i++) {
                int next = next(i, now);
                if (next >= 0 && next < 100001 && dis[next] > dis[now] + 1) {
                    dis[next] = dis[now] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(dis[k]);
    }
}