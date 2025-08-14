import java.util.*;
import java.io.*;

class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for (int i = 0 ; i < r ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[start][end] = cost;
            dp[end][start] = cost;
        }

        for (int node = 1 ; node <= n ; node++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][node] + dp[node][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] <= m) {
                    sum += arr[j];
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}