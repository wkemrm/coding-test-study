import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (a, b) ->  {
            return b - a;
        });

        int count = 0;
        int coin = k;
        for (int i = 0 ; i < n ; i++) {
            if (coin == 0) break;
            if (coin < arr[i]) continue;

            count += (coin / arr[i]);
            coin = coin % arr[i];
        }

        System.out.println(count);
    }
}