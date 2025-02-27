import java.util.*;
import java.io.*;

class Main {
    static int[][] display = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
    static int n;
    static int k;
    static int p;
    static int x;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] now = convert(x);
        for (int i = 1 ; i <= n ; i++) {
            if (i == x) continue;
            if (check(convert(i), now)) {
                result++;
            }
        }
        System.out.println(result);
    }
    public static boolean check(int[] target, int[] now) {
        int diffCount = 0;
        for (int i = 0 ; i < k ; i++) {
            for (int j = 0 ; j < 7 ; j++) {
                if (display[target[i]][j] != display[now[i]][j]) {
                    diffCount++;
                }
                if (diffCount > p) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] convert(int su) {
        int[] result = new int[k];
        for (int i = k - 1 ; i >= 0 ; i--) {
            result[i] = su % 10;
            su /= 10;
        }
        return result;
    }
}