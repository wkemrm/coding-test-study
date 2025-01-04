import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for (int i = 0 ; i < m ; i++) {
            sum += arr[i];
        }
        int count = 1;
        int maxSum = sum;
        
        for (int i = m ; i < n ; i++) {
            sum += arr[i] - arr[i - m];
            if (maxSum < sum) {
                maxSum = sum;
                count = 1;
            } else if (maxSum == sum){
                count++;
            }
        }
        
        
        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}