import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = i + 1;
        }
        
        int lt = 0;
        int rt = 0;
        int sum = 0;
        int result = 0;
        
        while(true) {
            if (rt >= n) {
                break;
            }
            if (sum < n) {
                sum += arr[rt++];
            } else if (sum > n) {
                sum -= arr[lt++];
            } else {
                result++;
                sum += arr[rt++];
            }
        }
        
        if (n == 1) result = 1;
        else result++;
        
        System.out.print(result);
    }
}