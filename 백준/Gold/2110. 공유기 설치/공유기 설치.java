import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = max;

        int res = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (c > count(mid)) {
                rt = mid - 1;
            } else {
                res = mid;
                lt = mid + 1;
            }
        }

        System.out.print(res);
    }

    public static int count(int mid) {
        int count = 1;
        int next = arr[0] + mid;

        for (int i = 1 ; i < n ; i++) {
            if (arr[i] >= next) {
                count++;
                next = arr[i] + mid;
            }
        }

        return count;
    }
}