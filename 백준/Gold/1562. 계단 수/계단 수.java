import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 1000000000;
        long[][][] dp = new long[n + 1][10][1024];

        for (int i = 1 ; i <= 9 ; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2 ; i <= n ; i++) {
            for (int j = 0 ; j <= 9 ; j++) {
                for (int k= 1 ; k < 1024 ; k++) {
                    int nextBit = k | (1 << j);

                    if (j == 0) {
                        dp[i][j][nextBit] = (dp[i][j][nextBit]+ dp[i - 1][1][k]) % mod;
                    } else if (j == 9) {
                        dp[i][j][nextBit] = (dp[i][j][nextBit] + dp[i - 1][8][k]) % mod;
                    } else {
                        dp[i][j][nextBit] = (dp[i][j][nextBit] + (dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % mod) % mod;
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0 ; i <= 9 ; i++) {
            sum = (sum + dp[n][i][1023]) % mod;
        }
        System.out.println(sum);



    }



}