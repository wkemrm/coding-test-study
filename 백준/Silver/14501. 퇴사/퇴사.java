import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tArr = new int[n + 1];
        int[] pArr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tArr[i] = t;
            pArr[i] = p;
        }

        for (int i = 1 ; i <= n ; i++) {
            if (tArr[i] + i - 1 > n) continue;
            dp[i] = pArr[i];
            for (int j = 1 ; j < i ; j++) {
                if (tArr[j] + j <= i) {
                    dp[i] = Math.max(dp[j] + pArr[i], dp[i]);
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            result = Math.max(result, dp[i]);
        }
        
        System.out.print(result);
    }
}