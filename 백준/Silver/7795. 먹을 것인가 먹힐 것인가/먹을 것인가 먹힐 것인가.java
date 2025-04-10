import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int testCase = 0 ; testCase < t ; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());

            Integer[] a = new Integer[aSize];
            Integer[] b = new Integer[bSize];
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < aSize ; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < bSize ; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a, Collections.reverseOrder());
            Arrays.sort(b, Collections.reverseOrder());

            int aPoint = 0;
            int bPoint = 0;
            int count = 0;
            int plus = bSize;

            while (aPoint < aSize && bPoint < bSize) {
                if (a[aPoint] > b[bPoint]) {
                    count += plus;
                    aPoint++;
                } else {
                    bPoint++;
                    plus--;
                }
            }

            System.out.println(count);
        }
    }
}