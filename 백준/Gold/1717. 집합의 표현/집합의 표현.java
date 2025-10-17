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
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (cal == 0) {
                union(a, b);
            } else {
                int fa = find(a);
                int fb = find(b);
                if (fa == fb) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    
    public static int find(int input) {
        if (arr[input] == input) {
            return input;
        }
        return arr[input] = find(arr[input]);
    }
    
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if (fa < fb) {
            arr[fb] = fa;
        } else {
            arr[fa] = fb;
        }
    }
}