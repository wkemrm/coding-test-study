import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];
        int result = 0;
        while(true) {
            if (end >= n) {
                break;
            }
            if (sum < m) {
                sum += arr[++end];
            } else if(sum == m) {
                sum += arr[++end];
                result++;
            } else if (sum > m) {
                sum -= arr[start++];
            }
        }
        System.out.print(result);
    }
}