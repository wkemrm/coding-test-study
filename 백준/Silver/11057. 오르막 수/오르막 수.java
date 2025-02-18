import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 0 ; i < 10 ; i++) {
            dp[1][i] = i + 1;
        }

        if (n == 1) {
            System.out.print(dp[1][9]);
            return;
        }
        for (int i = 2 ; i <= n ; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1 ; j < 10 ; j++) {
                dp[i][j] = ((dp[i - 1][j] % 10007) + (dp[i][j - 1] % 10007)) % 10007;
            }
        }


        System.out.print(dp[n][9]);
    }
}