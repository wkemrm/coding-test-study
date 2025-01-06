import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;

    public static int leftRed() {
        int count = 0;
        boolean flag = false;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i] == 0) flag = true;

            if (arr[i] == 1 && flag) count++;
        }
        return count;
    }

    public static int leftBlue() {
        int count = 0;
        boolean flag = false;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i] == 1) flag = true;

            if (arr[i] == 0 && flag) count++;
        }
        return count;
    }

    public static int rightRed() {
        int count = 0;
        boolean flag = false;
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (arr[i] == 0) flag = true;

            if (arr[i] == 1 && flag) count++;
        }
        return count;
    }

    public static int rightBlue() {
        int count = 0;
        boolean flag = false;
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (arr[i] == 1) flag = true;

            if (arr[i] == 0 && flag) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        char[] charArr = br.readLine().toCharArray();
        for (int i = 0 ; i < n ; i++) {
            if (charArr[i] == 'R') {
                arr[i] = 1;
            } else if (charArr[i] == 'B'){
                arr[i] = 0;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(leftRed());
        list.add(leftBlue());
        list.add(rightBlue());
        list.add(rightRed());

        System.out.print(Collections.min(list));
    }
}