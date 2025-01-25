import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < testCase ; i++) {
            testCase(br);
        }
    }

    public static void testCase(BufferedReader br) throws IOException {
        char[] input = br.readLine().toCharArray();
        int k = Integer.parseInt(br.readLine());

        if(k == 1) { 
            System.out.println("1 1");
            return;
        }

        int[] alphabet = new int[26];
        for (int i = 0 ; i < input.length ; i++) {
            alphabet[input[i] - 'a'] += 1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < input.length ; i++) {
            if (alphabet[input[i] - 'a'] < k) continue;

            int count = 1;
            for (int j = i + 1 ; j < input.length ; j++) {
                if (input[i] == input[j]) count++;

                if (count == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min + " " + max);
        }
    }
}