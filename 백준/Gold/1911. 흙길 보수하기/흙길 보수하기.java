import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n][2];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (o1, o2) -> (int)(o1[0] - o2[0]));

        int result = 0;
        long fill = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i][1] < fill) continue;

            if (arr[i][0] > fill) fill = arr[i][0];

            result += (int) (arr[i][1] - fill) / l;
            int remain = (int) (arr[i][1] - fill) % l;

            if (remain != 0) {
                result++;
                fill = arr[i][1] + l - remain;
            } else {
                fill = arr[i][1];
            }
        }

        System.out.println(result);

    }
}