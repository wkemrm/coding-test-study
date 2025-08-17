import java.util.*;
import java.io.*;

class Main {
    static int[] fuel = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            fuel[length] = cost;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int end = Integer.parseInt(st.nextToken());
        int nowCost = Integer.parseInt(st.nextToken());


        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0 ; i < end ; i++, nowCost--) {
            if (fuel[i] != 0) {
                pq.offer(fuel[i]);
            }

            if (nowCost == 0) {
                if (!pq.isEmpty()) {
                    nowCost += pq.poll();
                    answer++;
                } else {
                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}