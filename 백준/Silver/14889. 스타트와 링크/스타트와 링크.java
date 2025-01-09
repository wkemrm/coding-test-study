import java.util.*;
import java.io.*;

class Main {
    static int n;
    static boolean[] visited;
    static int[][] graph;
    static int result = Integer.MAX_VALUE;

    public static void combi(int depth, int before) {
        if (depth == n / 2) {
            diff();
        } else {
            for (int i = before ; i <= n ; i++) {
                visited[i] = true;
                combi(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void diff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 1 ; i < n ; i++) {
            for (int j = i + 1 ; j <= n ; j++) {
                if (visited[i] == true && visited[j] == true) {
                    startSum += graph[i - 1][j - 1] + graph[j - 1][i - 1];
                } else if (visited[i] == false && visited[j] == false) {
                    linkSum += graph[i - 1][j - 1] + graph[j - 1][i - 1];
                }
            }
        }
        result = Math.min(result, Math.abs(startSum - linkSum));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n + 1];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 1);
        System.out.print(result);
    }
}