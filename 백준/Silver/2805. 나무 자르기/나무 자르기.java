import java.util.*;
import java.io.*;

class Main {
    static int n;
    static long m;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new long[n];
        m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long max = Long.MIN_VALUE;

        for (int i = 0 ; i < n ; i++) {
            long input = Long.parseLong(st.nextToken());
            arr[i] = input;
            max = Math.max(max, input);
        }

        long start = 0;
        long end = max;
        while(start <= end) {
            long mid = (start + end) / 2;
            if (check(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.print(end);
    }

    public static boolean check(long mid) {
        long sum = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i] > mid) sum += (arr[i] - mid);
        }

        if (sum >= m) {
            return true;
        } else {
            return false;
        }
    }
}