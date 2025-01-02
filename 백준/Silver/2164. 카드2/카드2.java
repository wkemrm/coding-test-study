import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1 ; i <= n ; i++) {
            q.offer(i);
        }
        int i = 1;
        while(q.size() > 1) {
            if (i % 2 == 1) {
                q.poll();
            } else {
                q.offer(q.poll());
            }
            i++;
        }
        System.out.print(q.poll());
    }
}