import java.util.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[v + 1][v + 1];
        for (int i = 1 ; i <= v ; i++) {
            for (int j = 1 ; j <= v ; j++) {
                dp[i][j] = INF;
                if (i == j) dp[i][j] = 0;
            }
        }
        
        for (int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[start][end] = cost;
        }
        
        for (int node = 1 ; node <= v ; node++) {
            for (int i = 1 ; i <= v ; i++) {
                if (node == i) continue;
                for (int j = 1 ; j <= v ; j++) {
                    if (node == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][node] + dp[node][j]);
                }
            }
        }
        
        int result = INF;
        for (int i = 1 ; i <= v ; i++) {
            for (int j = i + 1 ; j <= v ; j++) {
                result = Math.min(dp[i][j] + dp[j][i], result);
            }
        }
        
        if (result == INF) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
    }
}