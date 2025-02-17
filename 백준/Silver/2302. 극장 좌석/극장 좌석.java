import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];

        for (int i = 0 ; i < m ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == m) {
            System.out.print(1);
            return;
        }
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i < 41 ; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int result = 1;
        int beforeSeat = 0;

        for (int i = 0 ; i < m ; i++) {
            result *= dp[arr[i] - beforeSeat - 1];
            beforeSeat = arr[i];
        }
        result *= dp[n - beforeSeat];


        System.out.print(result);
    }
}