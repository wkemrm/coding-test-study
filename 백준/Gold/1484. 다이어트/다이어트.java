import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int now = 1;
        int gida = 1;
        boolean flag = false;
        while(now < 100000) {
            long nowZegob = (long)now * now;
            long gidaZegob = (long)gida * gida;
            
            if (nowZegob - gidaZegob == n) {
                System.out.println(now);
                flag = true;
            }
            
            if (nowZegob - gidaZegob > n) {
                gida++;
            } else {
                now++;
            }
        }
        
        if (!flag) {
            System.out.print(-1);
        }
    }
}