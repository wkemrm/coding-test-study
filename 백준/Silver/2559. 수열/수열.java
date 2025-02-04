import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = m - 1;
        int sum = 0;
        for (int i = 0 ; i <= end ; i++) {
            sum += arr[i];
        }
        int result = sum;

        while (end < n - 1) {
            sum -= arr[start];
            start++;
            end++;
            sum += arr[end];
            result = Math.max(result, sum);
        }

        System.out.print(result);
    }
}