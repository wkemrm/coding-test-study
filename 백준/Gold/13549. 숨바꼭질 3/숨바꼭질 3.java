import java.util.*;
import java.io.*;

class Main {

    public static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dis = new int[100001];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dis[n] = 0;
        pq.offer(new Node(n, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int nowN = now.n;
            int nowCost = now.cost;

            if (nowCost > dis[nowN]) continue;

            if (nowN - 1 >= 0 && nowCost + 1 < dis[nowN - 1]) {
                dis[nowN - 1] = nowCost + 1;
                pq.offer(new Node(nowN - 1, nowCost + 1));
            }

            if (nowN + 1 <= 100000 && nowCost + 1 < dis[nowN + 1]) {
                dis[nowN + 1] = nowCost + 1;
                pq.offer(new Node(nowN + 1, nowCost + 1));
            }

            if (nowN * 2 <= 100000 && nowCost < dis[nowN * 2]) {
                dis[nowN * 2] = nowCost;
                pq.offer(new Node(nowN * 2, nowCost));
            }
        }

        System.out.println(dis[k]);
    }
}