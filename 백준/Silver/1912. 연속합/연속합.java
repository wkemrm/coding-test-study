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
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            if (result < dp[i]) result = dp[i];
        }
        
        System.out.print(result);
    }
}