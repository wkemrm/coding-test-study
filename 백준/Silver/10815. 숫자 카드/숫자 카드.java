import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m ; i++) {
            int input = Integer.parseInt(st.nextToken());

            System.out.print(solution(input)  + " ");
        }

    }

    public static int solution(int input) {
        int lt = 0;
        int rt = n - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == input) {
                return 1;
            }

            if (arr[mid] < input) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return 0;
    }
}