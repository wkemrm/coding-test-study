import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 3 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3 ; i++) {
            dp[1][i] = arr[1][i];
        }

        for (int i = 2 ; i <= n ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] = min + arr[i][j];
            }
        }

        int result = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(result);
    }
}