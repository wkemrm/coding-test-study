import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        arr = new int[m];
        for (int i = 0 ; i < m ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(DFS(0, one, two));
    }


    public static int DFS(int level, int one, int two) {
        if (level >= m) {
            return 0;
        }

        return Math.min(
                Math.abs(arr[level] - one) + DFS(level + 1, arr[level], two),
                Math.abs(arr[level] - two) + DFS(level + 1, one, arr[level])
        );
    }
}