import java.util.*;
class Main {
    static int BLANK = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Arrays.fill(arr, BLANK);
        for (int i = 0 ; i < n ; i++) {
            int input = sc.nextInt();
            int count = 0;
            for (int j = 0 ; j < arr.length ; j++) {
                int tall = i + 1;
                if (arr[j] == BLANK) {
                    if (input == count) {
                        arr[j] = tall;
                        break;
                    }
                    count++;
                }
            }
        }
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}