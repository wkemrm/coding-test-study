import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int[] countArr = new int[100001];
        int max = 1;

        while (rt < n && lt <= rt) {
            if (countArr[arr[rt]] + 1 <= k) {
                countArr[arr[rt]] += 1;
                max = Math.max(max, rt - lt + 1);
                rt++;
            } else {
                countArr[arr[lt]] -= 1;
                lt++;
            }
        }

        System.out.print(max);
    }
}