import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for (int i = 0 ; i < n ; i++) {
            pq.offer(sc.nextLong());
        }
        
        for (int i = 0 ; i < m ; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a + b);
            pq.offer(a + b);
        }
        
        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        
        System.out.print(sum);
    }
}