import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max + 1];

        int l = 0;
        int r = 0;
        long result = 0l;
        while(l < n) {
            while(r < n && count[arr[r]] == 0) {
                count[arr[r]]++;
                r++;
            }
            result += (r - l);
            count[arr[l]]--;
            l++;

        }

        System.out.print(result);
    }
}