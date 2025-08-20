import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        s.append(br.readLine());
        t.append(br.readLine());

        while(t.length() > s.length()) {
            char last = t.charAt(t.length() - 1);
            if (last == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if (t.toString().equals(s.toString())) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}