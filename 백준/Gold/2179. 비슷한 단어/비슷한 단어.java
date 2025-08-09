import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        
        for (int i = 0 ; i < n ; i++) {
            arr[i] = br.readLine();
        }
        
        int cnt = 0;
        String S = "";
        String T = "";
        
        for (int i = 0 ; i < n ; i++) {
            String first = arr[i];
            for (int j = i + 1 ; j < n ; j++) {
                String second = arr[j];
                int count = 0;
                int len = first.length() < second.length() ? first.length() : second.length();
                for (int k = 0 ; k < len ; k++) {
                    if (first.charAt(k) != second.charAt(k)) {
                        break;
                    }
                    count++;
                }
                
                if (cnt < count) {
                    cnt = count;
                    S = first;
                    T = second;
                }
            }
        }
        
        System.out.println(S);
        System.out.println(T);
    }
}