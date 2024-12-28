import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dasom = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1 ; i < n ; i++) {
            pq.offer(sc.nextInt());
        }
        int count = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            dasom++;
            count++;
            pq.offer(pq.poll() - 1);
        }
        System.out.print(count);
    }
}