import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n + 1][2];
        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
            arr[i][1] = arr[i - 1][0];
        }

        System.out.println(arr[n][0] + arr[n][1]);
    }


}