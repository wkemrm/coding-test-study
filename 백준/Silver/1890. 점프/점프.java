import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dis = new long[n][n];
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dis[0][0] = 1;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i == n - 1 && j == n - 1) continue;
                int nx = i + arr[i][j];
                int ny = j + arr[i][j];
                if (nx >= 0 && nx < n) {
                    dis[nx][j] += dis[i][j];
                }
                if (ny >= 0 && ny < n) {
                    dis[i][ny] += dis[i][j];
                }
            }
        }

        System.out.print(dis[n - 1][n - 1]);
    }
}