import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] doc = br.readLine().toCharArray();
        char[] word = br.readLine().toCharArray();
        
        int i = 0;
        int result = 0;
        while(i + word.length - 1 < doc.length) {
            boolean flag = true;
            
            for (int k = 0 ; k < word.length ; k++) {
                if (doc[k + i] != word[k]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                result++;
                i += word.length;
            } else {
                i++;
            }
        }
        
        System.out.print(result);
    }
}