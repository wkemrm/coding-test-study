import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dead = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            arr[i][0] = dead;
            arr[i][1] = cnt;
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i++) {
            int nowDead = arr[i][0];
            int nowCnt = arr[i][1];
            if (nowDead > pq.size()) {
                pq.offer(nowCnt);
            } else {
                if (pq.peek() < nowCnt) {
                    pq.poll();
                    pq.offer(nowCnt);
                }
            }
        }
        
        int result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }
        
        System.out.print(result);
    }
}