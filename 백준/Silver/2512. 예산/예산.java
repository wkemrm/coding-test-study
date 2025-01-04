import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int max;
    static int m;
    
    public static int condition(int mid) {
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            int su = (arr[i] > mid) ? mid : arr[i];
            sum += su;
        }
        return sum;
    }
    
    public static int solution() {        
        int lt = 0;
        int rt = max;
        
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (condition(mid) <= m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return rt;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = Integer.MIN_VALUE;
        arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (max < input) {
                max = input;
            }
            arr[i] = input;
        }
        m = Integer.parseInt(br.readLine());
        System.out.print(solution());
        
    }
}