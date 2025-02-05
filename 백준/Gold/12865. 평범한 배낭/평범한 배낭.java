import java.util.*;
import java.io.*;

class Node {
    int w;
    int v;

    public Node(int w, int v) {
        this.w = w;
        this.v = v;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new Node(w, v);
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int bag = 1 ; bag <= k ; bag++) {
            for (int i = 1 ; i <= n ; i++) {
                if (arr[i].w > bag) {
                    dp[bag][i] = dp[bag][i - 1];
                } else if (arr[i].w <= k) {
                    dp[bag][i] = Math.max(dp[bag - arr[i].w][i - 1] + arr[i].v, dp[bag][i - 1]);
                }
            }
        }
        System.out.print(dp[k][n]);
    }
}