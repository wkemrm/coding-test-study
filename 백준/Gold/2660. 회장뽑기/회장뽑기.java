import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<Integer>());
        }
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == - 1 && end == -1) {
                break;
            }

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int[] result = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            result[i] = solution(i);
        }

        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            if (min == result[i]) {
                count++;
            }
        }

        System.out.println(min + " " + count);
        for (int i = 1 ; i <= n ; i++) {
            if (min == result[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static class Node implements Comparable<Node> {
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
    public static int solution(int index) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[index] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(index, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int nowCost = node.cost;

            for (int next : graph.get(now)) {
                if (dis[next] > nowCost + 1) {
                    dis[next] = nowCost + 1;
                    pq.offer(new Node(next, nowCost + 1));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            max = Math.max(max, dis[i]);
        }
        min = Math.min(min, max);
        return max;
    }
}