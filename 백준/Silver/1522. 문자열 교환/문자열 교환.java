import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int k = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == 'a') k++;
        }

        int count = 0;
        for (int i = 0 ; i < k ; i++) {
            if (arr[i] == 'b') count++;
        }

        int result = count;

        for (int i = 1 ; i < arr.length ; i++) {
            int start = i;
            int end = (start + k - 1) % arr.length;

            if (arr[start - 1] == 'b') count--;

            if (arr[end] == 'b') count++;

            result = Math.min(result, count);
        }

        System.out.println(result);
    }
}