import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = 0;
        int result = 0;
        
        while(idx < n) {
            if (arr[idx] > 0) {
            int temp = arr[idx];
            result += temp * 3;
            arr[idx] = 0;
            temp = Math.min(temp, arr[idx + 1]);
            result += temp * 2;
            arr[idx + 1] = arr[idx + 1] - temp;
            temp = Math.min(temp, arr[idx + 2] - Math.min(arr[idx + 1], arr[idx + 2]));
            result += temp * 2;
            arr[idx + 2] = arr[idx + 2] - temp; 
            }
            idx++;
        }
        System.out.print(result);
        
        
    }
}