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
        
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (input == 0) {
                union(a, b);
            } else {
                int root1 = find(a);
                int root2 = find(b);
                if (root1 == root2) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    
    public static int find(int num) {
        if (num == arr[num]) {
            return num;
        }
        
        return find(arr[num]);
    }
    
    public static void union(int first, int second) {
        first = find(first);
        second = find(second);
        
        arr[second] = first;
    }
}