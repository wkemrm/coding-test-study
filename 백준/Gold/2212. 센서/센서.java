import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(arr);
        for (int i = 0 ; i < n - 1 ; i++) {
            pq.offer(arr[i + 1] - arr[i]);
        }
        
        int answer = 0;
        for (int i = 0 ; i < n - k ; i++) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }

}