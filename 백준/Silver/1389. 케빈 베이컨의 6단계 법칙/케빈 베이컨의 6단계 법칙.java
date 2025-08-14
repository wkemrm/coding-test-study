import java.util.*;
import java.io.*;

class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dp[start][end] = 1;
            dp[end][start] = 1;
        }

        for (int node = 1 ; node <= n ; node++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (i == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][node] + dp[node][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int result = n;
        for (int i = n ; i >= 1 ; i--) {
            int sum = 0;
            for (int j = 1 ; j <= n ; j++) {
                if (i == j || dp[i][j] >= INF) continue;
                sum += dp[i][j];
            }
            if (min >= sum) {
                min = sum;
                result = i;
            }
        }


        System.out.println(result);
    }
}