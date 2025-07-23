import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            dp[i] = i;
        }
        int max = (int)Math.sqrt(n);

        for (int i = 1 ; i <= max ; i++) {
            int sqrt = i * i;
            for (int j = 1 ; j <= n ; j++) {
                if (j < sqrt) continue;
                dp[j] = Math.min(dp[j], dp[j - sqrt] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}