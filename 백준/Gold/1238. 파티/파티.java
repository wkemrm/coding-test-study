import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        int[] returnDist = solution(n, x);

        int result = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            int[] goingDist = solution(n, i);
            result = Math.max(goingDist[x] + returnDist[i], result);
        }

        System.out.print(result);
    }

    public static int[] solution(int n, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;

            if (check[now]) continue;
            check[now] = true;

            for (Node next : graph.get(now)) {
                if (dist[next.index] > dist[now] + next.cost) {
                    dist[next.index] = dist[now] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist;
    }
}