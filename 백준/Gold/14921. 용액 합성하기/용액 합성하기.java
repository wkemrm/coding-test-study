import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt  = n - 1;
        long minAbs = Math.abs(arr[rt] + arr[lt]);
        long result = arr[rt] + arr[lt];

        while (lt < rt) {
            long sum = arr[rt] + arr[lt];
            long abs = Math.abs(sum);

            if (abs < minAbs) {
                minAbs = abs;
                result = sum;
            }

            if (0 > sum) {
                lt++;
            } else if (0 < sum) {
                rt--;
            } else {
                result = 0;
                break;
            }
        }

        System.out.print(result);
    }
}