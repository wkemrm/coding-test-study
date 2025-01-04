import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0 ; i < n ; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                pq.offer(input);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}