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
        int result = 0;
        for (int i = 0 ; i < n ; i++) {
            int lt = 0;
            int rt = n - 1;
            while(true) {
                if (lt == i) {
                    lt++;
                } else if(rt == i) {
                    rt--;
                }

                if (lt >= rt) break;

                int sum = arr[lt] + arr[rt];
                if (sum > arr[i]) {
                    rt--;
                } else if (sum < arr[i]){
                    lt++;
                } else if (sum == arr[i]) {
                    result++;
                    break;
                }
            }
        }
        System.out.print(result);
    }
}