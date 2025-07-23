import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0 ; i <= n ; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2 ; i <= k ; i++) {
            dp[i][0] = 1;
            for (int j = 1 ; j <= n ; j++) {
                for (int t = 0 ; t <= j ; t++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][t]) % 1000000000;
                }
            }
        }

        System.out.println(dp[k][n]);

    }
}