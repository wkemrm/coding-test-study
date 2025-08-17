import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] ruby = new int[n][2];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            ruby[i][0] = weight;
            ruby[i][1] = value;
        }

        int[] bag = new int[k];
        for (int i = 0 ; i < k ; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ruby, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        long answer = 0;
        for (int i = 0 ; i < k ; i++) {
            int weight = bag[i];
            while (j < n) {
                if (weight < ruby[j][0]) {
                    break;
                }
                pq.offer(ruby[j++][1]);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}