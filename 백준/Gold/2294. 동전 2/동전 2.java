import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dis = new int[k + 1];
        int[] arr = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1 ; i <= k ; i++) {
            for (int now = 0 ; now < n ; now++) {
                int next = i - arr[now];
                if (next >= 0 && dis[next] != Integer.MAX_VALUE) {
                    dis[i] = Math.min(dis[i], dis[next] + 1);
                }
                
            }
        }

        if (dis[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dis[k]);
        }
    }

}