import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            arr[i] = i;
        }

        for (int i = 1 ; i <= n ; i++) {
            int start = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                int end = j;
                int union = Integer.parseInt(st.nextToken());
                if (union == 1) {
                    union(start, end);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = new int[m];
        for (int i = 0 ; i < m ; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        int first = find(target[0]);
        boolean flag = true;
        for (int i = 1 ; i < m ; i++) {
            int search = find(target[i]);
            if (search != first) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int find(int a) {
        if (a != arr[a]) {
            return arr[a] = find(arr[a]);
        }

        return a;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) {
                arr[a] = b;
            } else {
                arr[b] = a;
            }
        }
    }

}