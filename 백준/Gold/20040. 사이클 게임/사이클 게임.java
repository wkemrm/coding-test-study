import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 0 ; i <= n ; i++) {
            arr[i] = i;
        }
        
        for (int i = 1 ; i <= m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = find(a);
            b = find(b);
            if (a == b) {
                System.out.print(i);
                return;
            }
            union(a, b);
        }
        
        System.out.print(0);
    }

    public static int find(int num) {
        if (num != arr[num]) {
            return arr[num] = find(arr[num]);
        }
        return num;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}