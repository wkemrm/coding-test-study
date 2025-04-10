import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;
        int result = 0;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            
            if (sum < m) {
                lt++;
            } else if(sum > m) {
                rt--;
            } else {
                result++;
                rt--;
            }
        }
        
        System.out.print(result);
    }
}