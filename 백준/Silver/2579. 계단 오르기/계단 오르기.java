import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][3];
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = arr[1];

        for (int i = 2 ; i <= n ; i++) {
            dp[i][1] = dp[i - 1][2] + arr[i];
            dp[i][2] = Math.max(dp[i - 2][1], dp[i - 2][2]) + arr[i];
        }

        System.out.print(Math.max(dp[n][1], dp[n][2]));
    }
}