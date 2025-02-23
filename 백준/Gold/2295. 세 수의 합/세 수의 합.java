import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] sum = new int[(n * (n + 1)) / 2];
        int index = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                sum[index++] = arr[i] + arr[j];
            }
        }
        
        Arrays.sort(sum);
        int result = Integer.MIN_VALUE;
        for (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = n - 1 ; j >= 0 ; j--) {
                int minus = arr[i] - arr[j];
                if (Arrays.binarySearch(sum, minus) > -1) {
                    result = Math.max(result, arr[i]);
                }
            }
        }
        
        System.out.print(result);
    }
}