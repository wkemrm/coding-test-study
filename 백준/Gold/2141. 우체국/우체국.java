import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];

        long sum = 0;
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            sum += arr[i][1];
        }

        Arrays.sort(arr, (o1, o2) -> (int)(o1[0] - o2[0]));

        long result = 0;
        long middle = (sum + 1) / 2;

        for (int i = 0 ; i < n ; i++) {
            result += arr[i][1];
            if (middle <= result) {
                System.out.print(arr[i][0]);
                break;
            }
        }
    }
}