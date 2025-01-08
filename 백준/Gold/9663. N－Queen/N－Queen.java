import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int count;
    
    public static void solution(int depth) {
        if (depth == n) {
            count++;
        } else {
            for (int i = 0 ; i < n ; i++) {
                arr[depth] = i;
                
                if (possible(depth)) {
                    solution(depth+1);
                }
            }
        }
    }
    
    public static boolean possible(int col) {
        for (int i = 0 ; i < col ; i++) {
            if (arr[col] == arr[i]) return false;
            
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        solution(0);
        
        System.out.print(count);
    }
}