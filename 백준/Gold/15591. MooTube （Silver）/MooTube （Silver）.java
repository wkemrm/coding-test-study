import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int q;
    static List<List<Node>> graph = new ArrayList<>();
    static long[][] question;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());


        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        question = new long[q][2];

        for (int i = 0 ; i < n - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        for (int i = 0 ; i < q ; i++) {
            st = new StringTokenizer(br.readLine());
            question[i][0] = Long.parseLong(st.nextToken());
            question[i][1] = Long.parseLong(st.nextToken());
        }

        for (int i = 0 ; i < q ; i++) {
            System.out.println(BFS(question[i][0], (int) question[i][1]));
        }
    }

    public static int BFS(long k, int v) {
        int result = 0;
        boolean[] visited = new boolean[n + 1];

        visited[v] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(v, 1000000001));

        while(!q.isEmpty()) {
            Node now = q.poll();
            int nowV = now.vex;
            long nowCost = now.cost;

            for (Node next : graph.get(nowV)) {
                if (!visited[next.vex]) {
                    long min = Math.min(nowCost, next.cost);
                    if (min >= k) result++;
                    visited[next.vex] = true;
                    q.offer(new Node(next.vex, min));
                }

            }
        }
        return result;
    }

    public static class Node {
        int vex;
        long cost;
        public Node(int vex, long cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

}