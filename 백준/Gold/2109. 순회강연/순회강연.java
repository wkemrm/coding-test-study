import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i][0] = p;
            arr[i][1] = d;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] ob1, int[] ob2) {
                if (ob1[1] != ob2[1]) {
                    return ob1[1] - ob2[1];
                }
                return ob2[0] - ob1[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i++) {
            if (pq.size() < arr[i][1]) {
                pq.offer(arr[i][0]);
            } else {
                if (pq.peek() < arr[i][0]) {
                    pq.poll();
                    pq.offer(arr[i][0]);
                }
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.print(result);
    }
}