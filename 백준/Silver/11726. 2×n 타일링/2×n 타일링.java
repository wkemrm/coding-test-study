import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[0] = 0l;
        dp[1] = 1l;
        dp[2] = 2l;
        for (int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])  % 10007;
        }

        System.out.print(dp[n]);
    }
}