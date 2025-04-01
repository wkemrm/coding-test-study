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
        int start = 0;
        int end = n - 1;
        int result = Integer.MAX_VALUE;
        int resultS = 0;
        int resultE = n - 1;
        
        while(start < end) {
            int nowSum = arr[start] + arr[end];
            
            if (Math.abs(nowSum) < Math.abs(result)) {
                resultS = arr[start];
                resultE = arr[end];
                result = nowSum;
            }
            
            if (nowSum > 0) {
                end--;
            } else {
                start++;
            }
        }
        
        System.out.print(resultS + " " + resultE);
        
    }
}