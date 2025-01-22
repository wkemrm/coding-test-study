import java.util.*;
import java.io.*;;

class Main {
    static String s;
    static String t;
    static boolean result = false;
    public static void DFS(String input) {
        if (input.length() == s.length()) {
            if (input.equals(s)) result = true;
        } else {
            if (input.charAt(input.length() - 1) == 'A' && !result) {
                DFS(input.substring(0, input.length() - 1));
            }

            if (input.charAt(0) == 'B' && !result) {
                DFS(new StringBuffer(input.substring(1, input.length())).reverse().toString());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        DFS(t);

        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}