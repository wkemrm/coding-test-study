import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = (int) Math.sqrt(n);
        int[][] dis = new int[m + 1][n + 1];

        for (int i = 0 ; i <= n ; i++) {
            dis[1][i] = i;
        }

        for (int i = 2 ; i <= m ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                int min = dis[i - 1][j];
                if (j - (i * i) >= 0) {
                    min = Math.min(min, dis[i][j - (i * i)] + 1);
                }
                dis[i][j] = min;
            }
        }

        System.out.println(dis[m][n]);
    }

}