import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] visited = new int[n + 1];
        visited[0] = visited[1] = 0;
        dp[0] = dp[1] = 0;

        for (int i = 2 ; i <= n ; i++) {
            dp[i] = dp[i - 1] + 1;
            visited[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2]) {
                dp[i] = dp[i / 2] + 1;
                visited[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3]) {
                dp[i] = dp[i / 3] + 1;
                visited[i] = i / 3;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n;

        while (i >= 1) {
            sb.append(i + " ");
            i = visited[i];
        }

        System.out.println(dp[n]);
        System.out.println(sb.toString());
    }
}