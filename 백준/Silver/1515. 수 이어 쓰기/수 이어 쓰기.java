import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int point = 0;
        for (int i = 1 ; i <= 30000 ; i++) {
            String base = String.valueOf(i);
            for (int j = 0 ; j < base.length() ; j++) {
                if (base.charAt(j) == arr[point]) {
                    point++;
                }
                if (point == arr.length) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}