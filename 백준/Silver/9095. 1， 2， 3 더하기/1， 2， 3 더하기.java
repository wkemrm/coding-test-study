import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] dp = new int[12];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4 ; i < dp.length ; i++) {
            dp[i] = dp[i - 1] + dp[i -2] + dp[i - 3];
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0 ; i< testCase ; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}