import java.util.*;
import java.io.*;

class Main {
    static int f, s, g, u, d;

    public static void BFS() {
        boolean[] visited = new boolean[f + 1];
        int[] result = new int[f + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int nextU = cur + u;
            int nextD = cur - d;

            if (nextU <= f && !visited[nextU]) {
                visited[nextU] = true;
                result[nextU] = result[cur] + 1;
                q.offer(nextU);
            }

            if (nextD >= 1 && !visited[nextD]) {
                visited[nextD] = true;
                result[nextD] = result[cur] + 1;
                q.offer(nextD);
            }
        }

        if (visited[g] == false) {
            System.out.println("use the stairs");
        } else {
            System.out.print(result[g]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        BFS();
    }
}
