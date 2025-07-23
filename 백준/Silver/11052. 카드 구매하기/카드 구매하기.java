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

        dp[1] = arr[1];

        for (int i = 2 ; i <= n ; i++) {
            for (int j = i ; j >= 1 ; j--) {
                dp[i] = Math.max(dp[i - j] + arr[j], dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}