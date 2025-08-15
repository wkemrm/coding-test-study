import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        arr = new int[v + 1];
        for (int i = 1 ; i <= v ; i++) {
            arr[i] = i;
        }
        Edge[] edgeArr = new Edge[e];
        for (int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeArr[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edgeArr);

        int answer = 0;
        for (int i = 0 ; i < e ; i++) {
            Edge edge = edgeArr[i];

            int fa = find(edge.a);
            int fb = find(edge.b);

            if (fa != fb) {
                answer += edge.cost;
                union(edge.a, edge.b);
            }
        }

        System.out.print(answer);
    }

    public static int find(int num) {
        if (arr[num] != num) {
            return arr[num] = find(arr[num]);
        }
        return num;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}