import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        int mod = 1000000000;
        
        for (int i = 0 ; i <= 9 ; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2 ; i <= n ; i++) {
            for (int j = 0; j <= 9 ; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if(j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % mod + dp[i - 1][j + 1] % mod) % mod;
                }
            }
        }
        
        int result = 0;
        for (int i = 1 ; i <= 9 ; i++) {
            result += dp[n][i];
            result %= mod;
        }
        
        System.out.print(result % mod);
    }
}