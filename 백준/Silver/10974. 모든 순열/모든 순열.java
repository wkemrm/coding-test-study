import java.util.*;
import java.io.*;

class Main {
    static int n;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n  + 1];
        result = new int[n + 1];
        DFS(0);
    }

    public static void DFS(int depth) {
        if (depth == n) {
            for (int i = 1 ; i <= n ; i++) {
                if (visited[i]) System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1 ; i <= n ; i++) {
                if (visited[i]) continue;
                result[depth + 1] = i;
                visited[i] = true;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}