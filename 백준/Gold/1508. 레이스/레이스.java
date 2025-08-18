import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int k;
    static int[] possible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        possible = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k ; i++) {
            possible[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = n + 1;

        String result = "";
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            String ans = check(mid);

            if (ans.isEmpty()) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                result = ans;
            }
        }
        System.out.print(result);
    }

    public static String check(int num) {
        StringBuilder sb = new StringBuilder();
        int cnt = m - 1;
        sb.append(1);
        int before = possible[0];

        for (int i = 1 ; i < k ; i++) {
            if (possible[i] >= before + num && cnt > 0) {
                sb.append(1);
                before = possible[i];
                cnt--;
            } else {
                sb.append(0);
            }
        }

        if (cnt == 0) {
            return sb.toString();
        }

        return "";
    }
}