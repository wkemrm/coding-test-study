import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int oneDeleteCount = input.length() / 2 / 2;
        int zeroDeleteCount = input.length() / 2 / 2;
        for (int i = 0 ; i < input.length() ; i++) {
            if (oneDeleteCount == 0) break;
            if (input.charAt(i) == '1') {
                input = input.substring(0, i) + input.substring(i + 1);
                oneDeleteCount--;
            }
        }

        for (int i = input.length() - 1 ; i >= 0 ; i--) {
            if (zeroDeleteCount == 0) break;
            if (input.charAt(i) == '0') {
                input = input.substring(0, i) + input.substring(i + 1);
                zeroDeleteCount--;
            }
        }

        System.out.print(input);
    }
}