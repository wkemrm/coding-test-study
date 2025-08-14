import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int node = 1 ; node <= n ; node++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (dp[i][node] == 1 && dp[node][j] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}