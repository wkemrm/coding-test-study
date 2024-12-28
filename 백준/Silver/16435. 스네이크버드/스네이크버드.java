import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i++) {
            pq.offer(sc.nextInt());
        }
        while(!pq.isEmpty() && pq.poll() <= l) {
            l++;
        }
        
        System.out.print(l);
    }
}