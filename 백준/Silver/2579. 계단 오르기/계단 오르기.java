import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[301];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];
        for (int i = 4 ; i <= n ; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }

        System.out.print(dp[n]);
    }
}