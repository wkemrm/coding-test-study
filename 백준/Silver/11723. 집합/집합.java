import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bit = 0;
        int all = (1 << 21) - 1;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            if (method.equals("all")) {
                bit = all;
                continue;
            }

            if (method.equals("empty")) {
                bit = 0;
                continue;
            }
            int num = Integer.parseInt(st.nextToken());

            switch (method) {
                case "add" : {
                    bit |= (1 << num);
                    break;
                }
                case "remove" : {
                    bit &= (~(1 << num));
                    break;
                }
                case "check" : {
                    int check = bit & (1 << num);
                    if (check != 0) {
                       sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "toggle" : {
                    bit ^= (1 << num);
                    break;
                }
            }
        }

        System.out.println(sb);
    }



}