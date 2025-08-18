import java.util.*;
import java.io.*;

class Main {
    static int t;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < t ; i++) {
            input = br.readLine();
            if (check(0, input.length() - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean check(int start, int end) {
        if (start == end) return true;

        int mid = (start + end) / 2;

        for (int i = start ; i < mid ; i++) {
            if (input.charAt(i) == input.charAt(end - i)) {
                return false;
            }
        }

        return check(start, mid - 1) && check(mid + 1, end);
    }
}