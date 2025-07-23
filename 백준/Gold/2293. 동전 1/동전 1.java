import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1 ; i <= n ; i++) {
            dp[i][0] = 1;
            int now = arr[i];
            for (int j = 1 ; j <= k ; j++) {
                if (j < now) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i][j - now] + dp[i - 1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}