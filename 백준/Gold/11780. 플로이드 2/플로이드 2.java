import java.util.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    static int[][] next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                dp[i][j] = INF;
                if (i == j) dp[i][j] = 0;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (dp[start][end] > cost) {
                dp[start][end] = cost;
                next[start][end] = end;
            }
        }

        for (int node = 1 ; node <= n ; node++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (dp[i][j] > dp[i][node] + dp[node][j]) {
                        dp[i][j] = dp[i][node] + dp[node][j];
                        next[i][j] = next[i][node];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (dp[i][j] >= INF) {
                    dp[i][j] = 0;
                }
                sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
               if (next[i][j] == 0) {
                   sb.append("0\n");
                   continue;
               }
               sb.append(route(i, j) + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static String route(int start, int end) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        list.add(start);
        int now = next[start][end];
        while(now != 0) {
            list.add(now);
            now = next[now][end];

            count++;
        }

        String result = String.valueOf(count);

        for (Integer node : list) {
            result = result + " " + node;
        }
        return result;
    }
}