import java.util.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                dp[i][j] = INF;
                if (i == j) dp[i][j] = 0;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[start][end] = Math.min(dp[start][end] ,cost);
        }

        for (int node = 1 ; node <= n ; node++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][node] + dp[node][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (dp[i][j] >= INF) {
                    dp[i][j] = 0;
                }
                sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}