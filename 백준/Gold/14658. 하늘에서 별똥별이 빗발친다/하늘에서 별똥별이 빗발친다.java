import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int l;
    static int k;
    static Star[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new Star[k];
        for (int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Star(x, y);
        }
        
        int max = 0;
        for (int i = 0 ; i < k ; i++) {
            for (int j = 0 ; j < k ; j++) {
                max = Math.max(max, inBound(arr[i].x, arr[j].y));
            }
         
            
        } 
        
        System.out.print(k - max);
    } 
    
    public static int inBound(int x, int y) {
        int cnt = 0;
        for (int j = 0 ; j < k ; j++) {
            Star now = arr[j];
            if (now.x <= x + l && now.x >= x && now.y <= y + l && now.y >= y) {
              cnt++;
            }
        }
        
        return cnt;
    }
    
    public static class Star {
        int x;
        int y;
        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}