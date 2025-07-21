import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for (int i = 4 ; i <= n ; i = i + 2) {
            long sum = dp[i - 2] * 3;
            for (int j = i - 4 ; j >= 0 ; j = j - 2) {
                sum += (dp[j] * 2);
            }
            dp[i] = sum;
        }

        System.out.println(dp[n]);
    }
}