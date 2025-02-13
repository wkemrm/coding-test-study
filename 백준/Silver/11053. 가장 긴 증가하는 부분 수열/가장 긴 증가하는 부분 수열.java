import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1 ; i <= n ; i++) {
            dp[i] = 1;
            for (int j = 1 ; j < i ; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
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