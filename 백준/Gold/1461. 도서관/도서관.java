import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0 ; i < n ; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input > 0) {
                plus.offer(input);
            } else {
                minus.offer(Math.abs(input));
            }
            max = Math.max(max, Math.abs(input));
        }

        int result = 0;
        while (!plus.isEmpty()) {
            if (plus.size() >= m) {
                result += (plus.peek() * 2);
                for (int i = 0 ; i < m ; i++) {
                    plus.poll();
                }
            } else {
                result += (plus.poll() * 2);
                break;
            }
        }

        while (!minus.isEmpty()) {
            if (minus.size() >= m) {
                result += (minus.peek() * 2);
                for (int i = 0 ; i < m ; i++) {
                    minus.poll();
                }
            } else {
                result += (minus.poll() * 2);
                break;
            }
        }

        System.out.print(result - max);
    }
}