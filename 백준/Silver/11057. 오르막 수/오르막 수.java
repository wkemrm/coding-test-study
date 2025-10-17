import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // dp[i][j] = 길이가 i, 마지막 숫자가 j인 오르막 수
        int[][] dp = new int[N + 1][10];
        
        // 초기값: 길이 1
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }
        
        // DP 계산
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    // 마지막이 0이면 앞도 0만 가능
                    dp[i][j] = dp[i - 1][0];
                } else {
                    // 점화식 적용
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
                }
            }
        }
        
        // 답: 길이 N인 모든 오르막 수의 합
        int answer = 0;
        for (int j = 0; j <= 9; j++) {
            answer = (answer + dp[N][j]) % 10007;
        }
        
        System.out.println(answer);
    }
}