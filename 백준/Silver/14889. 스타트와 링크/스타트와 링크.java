import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void diff() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 1 ; i < n ; i++) {
            for (int j = i + 1 ; j <= n ; j++) {
                if (visited[i] == true && visited[j] == true) {
                    startSum += graph[i][j] + graph[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    linkSum += graph[i][j] + graph[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(startSum - linkSum));
    }

    public static void combi(int idx, int count) {
        if (count == n / 2) {
            diff();
            return;
        } else {
            for (int i = idx ; i <= n ; i++) {
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(1, 0);

        System.out.print(result);
    }
}