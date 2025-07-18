import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][10];
        for (int i = 0 ; i < 10 ; i++) {
            arr[1][i] = 1;
        }

        for (int now = 2 ; now <= n ; now++) {
            arr[now][0] = arr[now - 1][1];
            for (int i = 1 ; i < 9 ; i++) {
                arr[now][i] = (arr[now - 1][i - 1] + arr[now - 1][i + 1]) % 1000000000;
            }
            arr[now][9] = arr[now - 1][8];
        }

        int result = 0;
        for (int i = 1 ; i < 10 ; i++) {
            result = (result + arr[n][i]) % 1000000000;
        }

        System.out.println(result);
    }
}