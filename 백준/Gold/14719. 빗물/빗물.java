import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < w ; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for (int i = 1 ; i < w ; i++) {
            int left = 0;
            for (int j = i - 1 ; j >= 0 ; j--) {
                left = Math.max(left, height[j]);
            }
            
            int right = 0;
            for (int j = i + 1 ; j < w ; j++) {
                right = Math.max(right, height[j]);
            }
            
            if (left > height[i] && right > height[i]) {
                answer += (Math.min(left, right) - height[i]);
            }
        }
        
        System.out.print(answer);
    }
}