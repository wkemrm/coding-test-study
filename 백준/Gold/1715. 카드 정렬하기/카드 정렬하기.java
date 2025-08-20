import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i = 0 ; i < n ; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long num = 0;
        
        while(pq.size() > 1) {
            long one = pq.poll();
            long two = pq.poll();
            num += (one + two);
            pq.offer(one + two);
        }
        System.out.print(num);
    }
}