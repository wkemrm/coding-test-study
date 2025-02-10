import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1 ; i <= n ; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end] - dp[start - 1]);
        }
    }
}