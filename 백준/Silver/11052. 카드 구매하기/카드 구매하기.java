import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= n ; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < i ; j++) {
                dp[i] = Math.max(dp[j] + p[i - j], dp[i]);
            }
        }
        
        System.out.print(dp[n]);
    }
}