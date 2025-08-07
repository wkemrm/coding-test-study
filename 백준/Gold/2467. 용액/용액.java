import java.util.*;
import java.io.*;

class Main { public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }


        int lt = 0;
        int rt = n - 1;
        long min = Long.MAX_VALUE;
        long resultOne = arr[lt];
        long resultTwo = arr[rt];
        while(lt < rt) {
            long sum = arr[lt] + arr[rt];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                resultOne = arr[lt];
                resultTwo = arr[rt];
            }

            if (sum >= 0) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(resultOne + " " + resultTwo);
    }

}