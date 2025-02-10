import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int su = Integer.parseInt(br.readLine());
        int[] dp = new int[su + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2 ; i < dp.length ; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i % 2 == 0) {
                dp[i] = Math.min(1 + dp[i / 2], dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(1 + dp[i / 3], dp[i]);
            }
        }

        System.out.print(dp[su]);
    }
}