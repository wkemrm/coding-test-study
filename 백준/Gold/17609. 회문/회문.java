import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0 ; testCase < t ; testCase++) {
            String input = br.readLine();

            System.out.println(point(0, input.length() - 1, input, 0));
        }
    }
    
    public static int point(int start, int end, String s1, int check) {
        if (check >= 2) return 2;
        
        while (start < end) {
            if (s1.charAt(start) == s1.charAt(end)) {
                start++;
                end--;
            } else {
                return Math.min(point(start + 1, end, s1, check + 1), point(start, end - 1, s1, check + 1));
            }
        }
        return check;
    }   
}