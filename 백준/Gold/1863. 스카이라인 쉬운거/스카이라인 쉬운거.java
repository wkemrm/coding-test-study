import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            while(!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
            
            stack.push(y);
       }
        
       while(!stack.isEmpty()) {
           if (stack.peek() > 0) {
               answer++;
           }
           stack.pop();
       }
        
        System.out.print(answer);
    }
}