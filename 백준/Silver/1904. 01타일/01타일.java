import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.print(1);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746;
        }
        
        System.out.print(dp[n]);
    }
}