import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        DFS(0);

        System.out.println(count);
    }

    public static void DFS(int level) {
        if (level == n) {
            count++;
        } else {
            for (int i = 0 ; i < n ; i++) {
                arr[level] = i;

                if (possible(level)) {
                    DFS(level + 1);
                }
            }
        }
    }

    public static boolean possible(int depth) {
        int x = depth;
        int y = arr[depth];

        for (int i = 0 ; i < depth ; i++) {
            if (arr[i] == arr[depth]) return false;

            if (x - y == i - arr[i] || x + y == i + arr[i]) return false;
        }

        return true;
    }

}