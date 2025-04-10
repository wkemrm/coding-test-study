import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = 1;
        long result = arr[n - 1] - arr[0];

        while(rt < n) {
            if (lt == rt) {
                rt++;
                continue;
                
            }
            long nowMinus = arr[rt] - arr[lt];
            if (nowMinus >= m) {
                lt++;
                result = Math.min(result, nowMinus);
            } else if(nowMinus < m) {
                rt++;
                
            }
        }
        System.out.print(result);
    }
}