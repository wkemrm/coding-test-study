import java.util.*;
import java.io.*;

class Top {
    int index;
    int length;
    
    public Top(int index, int length) {
        this.index = index;
        this.length = length;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1];
        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= n ; i++) {
            int input = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if (stack.peek().length > input) {
                    result[i] = stack.peek().index;
                    break;
                }
                stack.pop();
            }
            stack.push(new Top(i, input));
        }
        
        for (int i = 1 ; i <= n ; i++) {
            System.out.print(result[i] + " ");
        }
    }
}