import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j - arr[i] > 0) {
                        dp[j] = dp[j] + dp[j - arr[i]];
                    } else if (j - arr[i] == 0) {
                        dp[j]++;
                    }
                }
            }

            System.out.println(dp[m]);
        }
    }
}