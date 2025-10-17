import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int x;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
        }

        System.out.print(dick());
    }

    public static int dick() {
        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        for (int i = 1 ; i <= n ; i++) {
            dis[i][i] = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            pq.offer(new Edge(i, 0));

            while(!pq.isEmpty()) {
                Edge nowEdge = pq.poll();
                int nowCost = nowEdge.cost;
                int now = nowEdge.end;

                if (dis[i][now] < nowCost) {
                    continue;
                }

                for (Edge edge : graph.get(now)) {
                    if (dis[i][edge.end] > edge.cost + nowCost) {
                        dis[i][edge.end] = edge.cost + nowCost;
                        pq.offer(new Edge(edge.end, edge.cost + nowCost));
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            max = Math.max(max, dis[i][x] + dis[x][i]);
        }

        return max;
    }

    static class Edge implements Comparable<Edge>{
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}