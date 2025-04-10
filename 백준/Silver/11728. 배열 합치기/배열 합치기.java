import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        int[] a = new int[aSize];
        int[] b = new int[bSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < aSize ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < bSize ; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int aPoint = 0;
        int bPoint = 0;

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (aPoint >= aSize && bPoint >= bSize) {
                break;
            } else if(aPoint >= aSize) {
                sb.append(b[bPoint++] + " ");
            } else if(bPoint >= bSize) {
                sb.append(a[aPoint++] + " ");
            } else {
                if (a[aPoint] > b[bPoint]) {
                    sb.append(b[bPoint++] + " ");
                } else {
                    sb.append(a[aPoint++] + " ");
                }
            }
        }

        System.out.println(sb.toString());
    }
}