import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 1, new int[n / 2]);
        System.out.println(min);
    }

    public static void DFS(int level, int x, int[] start) {
        if (level == n / 2) {
            solution(start);
        } else {
            for (int i = x ; i <= n ; i++) {
                start[level] = i;
                DFS(level + 1, i + 1, start);
            }
        }
    }

    public static void solution(int[] start) {
        boolean[] visited = new boolean[n + 1];

        int startSum = 0;
        for (int i = 0 ; i < start.length ; i++) {
            visited[start[i]] = true;
            for (int j = 0 ; j < start.length ; j++) {
                if (i == j) continue;
                startSum += arr[start[i]][start[j]];
            }
        }

        int linkSum = 0;
        for (int i = 1 ; i <= n ; i++) {
            if (visited[i]) continue;
            for (int j = 1 ; j <= n ; j++) {
                if (visited[j]) continue;
                if (i == j) continue;
                linkSum += arr[i][j];
            }
        }

        min = Math.min(Math.abs(startSum - linkSum), min);
    }
}