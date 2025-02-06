import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int s;
    static int[] arr;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1 ; i <= n ; i++) {
            DFS(0, i, 0);
        }
        
        System.out.print(result);
    }
    
    public static void DFS(int depth, int m, int cur) {
        if (depth == m) {
            int sum = 0;
            for (int i = 0 ; i < n ; i++) {
                if (visited[i]) sum += arr[i];
            }
            if (sum == s) result++;
        } else {
            for (int i = cur ; i < n ; i++) {
                if (visited[i]) continue;
                
                visited[i] = true;
                DFS(depth + 1, m, i + 1);
                visited[i] = false;
            }
        }
    }
}