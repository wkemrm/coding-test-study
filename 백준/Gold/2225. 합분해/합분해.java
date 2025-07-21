import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[k + 1][n + 1];

        for (int i = 0 ; i <= n ; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2 ; i <= k ; i++) {
            arr[i][0] = 1;
            for (int j = 1 ; j <= n ; j++) {
                int sum = 0;
                for (int r = 0 ; r <= j ; r++) {
                    sum = (sum + arr[i - 1][r]) % 1000000000;
                }
                arr[i][j] = sum % 1000000000;
            }
        }

        System.out.print(arr[k][n]);
    }
}