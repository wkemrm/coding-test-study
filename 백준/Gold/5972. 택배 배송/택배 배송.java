import java.sql.Array;
import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
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
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static boolean[] visited;
    static int[] dis;

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dis[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.index;
            int nowCost = nowNode.cost;

            if (visited[now]) continue;
            visited[now] = true;

            for (Node next : graph.get(now)) {
                if (dis[next.index] > nowCost + next.cost) {
                    dis[next.index] = nowCost + next.cost;
                    pq.offer(new Node(next.index, nowCost + next.cost));
                }
            }
        }

        System.out.println(dis[n]);
    }
}