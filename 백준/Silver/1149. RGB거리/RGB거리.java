import java.util.*;
import java.io.*;

class Main {
    static final int red = 0;
    static final int blue = 1;
    static final int green = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 3 ; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 2; i <= n ; i++) {
            dp[i][red] += Math.min(dp[i - 1][green], dp[i - 1][blue]);
            dp[i][green] += Math.min(dp[i - 1][red], dp[i - 1][blue]);
            dp[i][blue] += Math.min(dp[i - 1][red], dp[i - 1][green]);
        }

        int result = Math.min(Math.min(dp[n][red], dp[n][blue]), dp[n][green]);
        System.out.println(result);
    }
}