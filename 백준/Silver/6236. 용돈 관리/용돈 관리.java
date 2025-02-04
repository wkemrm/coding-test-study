import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solution());
    }

    public static int solution() {
        int lt = 1;
        int rt = 0;
        for (int i = 0 ; i < n ; i++) {
            rt += arr[i];
        }

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(mid)) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }

    public static boolean check(int money) {
        int remain = 0;
        int cnt = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i] > remain) {
                if (money < arr[i]) return false;
                cnt++;
                if (cnt > m) return false;
                remain = money - arr[i];
            } else {
                remain = remain - arr[i];
            }
        }

        return true;
    }
}