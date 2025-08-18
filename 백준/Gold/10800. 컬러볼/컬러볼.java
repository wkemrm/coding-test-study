import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[i] = new Node();
            arr[i].index = i + 1;
            arr[i].color = color;
            arr[i].cost = cost;
        }

        Arrays.sort(arr);

        long[] color = new long[n + 1];
        long[] result = new long[n + 1];

        long totalCost = 0;
        int idx = 0;
        for (int i = 1 ; i < n ; i++) {
            Node node = arr[i];

            while(arr[idx].cost < node.cost) {
                totalCost += arr[idx].cost;
                color[arr[idx].color] += arr[idx].cost;
                idx++;
            }

            result[node.index] = totalCost - color[node.color];
        }

        for (int i = 1 ; i <= n ; i++) {
            System.out.println(result[i]);
        }
    }
    static class Node implements Comparable<Node> {
        int index, color, cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}