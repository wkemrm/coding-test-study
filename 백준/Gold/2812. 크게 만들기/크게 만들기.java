import java.util.*;
import java.io.*;

class Main {
    // n - k 개의 수를 뽑는다.
    // 그 수가 3인 경우  4 3 2 1 이라고 쳤을 때 4, 3을 pq에 넣는다.
    // 가장 큰 값을 뽑는다.
    // pq를 초기화 시킨다.
    // 반복
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        char[] charArray = br.readLine().toCharArray();
        for (int i = 0 ; i < n ; i++) {
            arr[i] = charArray[i] - '0';
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1 ; i < n ; i++) {
            int now = arr[i];
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && k > 0 && stack.peek() < now) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(now);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        System.out.println(sb.toString());
    }

}