import java.util.*;
import java.io.*;

class Main {
    static int n;
    static boolean[] first;
    static boolean[] result;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        first = new boolean[n];
        result = new boolean[n];

        char[] firstArray = br.readLine().toCharArray();
        for (int i = 0 ; i < n  ; i++) {
            int input = firstArray[i] - '0';
            if (input == 0) {
                first[i] = false;
            } else {
                first[i] = true;
            }
        }

        char[] resultArray = br.readLine().toCharArray();
        for (int i = 0 ; i < n  ; i++) {
            int input = resultArray[i] - '0';
            if (input == 0) {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }


        boolean[] copy = first.clone();
        // 만약 0번째를 안누른 경우
        int count = 0;
        for (int i = 1 ; i < n ; i++) {
            if (copy[i - 1] != result[i - 1]) {
                push(copy, i);
                count++;
            }
        }

        boolean flag = true;
        for (int i = 0 ; i < n ; i++) {
            if (copy[i] != result[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            min = count;
        }

        copy = first.clone();
        push(copy, 0);
        int secondCount = 1;
        for (int i = 1 ; i < n ; i++) {
            if (copy[i - 1] != result[i - 1]) {
                push(copy, i);
                secondCount++;
            }
        }

        flag = true;
        for (int i = 0 ; i < n ; i++) {
            if (copy[i] != result[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            min = Math.min(min, secondCount);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void push(boolean[] arr, int index) {
        if (index == 0) {
            arr[0] = !arr[0];
            arr[1] = !arr[1];
        } else if (index == n - 1) {
            arr[n - 1] = !arr[n - 1];
            arr[n - 2] = !arr[n - 2];
        } else {
            arr[index] = !arr[index];
            arr[index - 1] = !arr[index - 1];
            arr[index + 1] = !arr[index + 1];
        }
    }
}