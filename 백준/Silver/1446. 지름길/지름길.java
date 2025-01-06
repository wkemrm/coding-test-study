import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] doro = new int[100001];
        Arrays.fill(doro, Integer.MAX_VALUE);
        ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();

        for (int i = 0 ; i < d ; i++) {
            list.add(new ArrayList<Edge>());
            list.get(i).add(new Edge(i + 1, 1));
        }

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(y, cost);
            if (y <= d)  list.get(x).add(edge);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        pq.offer(new Edge(0, 0));
        doro[0] = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.vex;
            int nowCost = edge.cost;
            if (now == d) break;
            for (Edge ob : list.get(now)) {
                if (doro[ob.vex] > nowCost + ob.cost) {
                    doro[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }

        System.out.print(doro[d]);
    }

}