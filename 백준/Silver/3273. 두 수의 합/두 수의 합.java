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
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int lt = 0;
        int rt = n - 1;
        int sum = 0;
        int result = 0;
        
        while (lt < rt) {
            int nowSum = arr[lt] + arr[rt];
            if (nowSum < x) {
                lt++;
            } else if (nowSum == x) {
                lt++;
                result++;
            }else if (nowSum > x) {
                rt--;
            }
        }
        
        System.out.print(result);
    }
}