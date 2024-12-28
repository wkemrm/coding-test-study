import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0 ; i < m ; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0 ; j < n ; j++) {
                arr[j] = sc.nextInt();
            }
            int max = arr[n - 1];
            long profit = 0;
            for (int k = n - 2 ; k >= 0 ; k--) {
                if (max > arr[k]) {
                    profit += max - arr[k];
                } else {
                    max = arr[k];
                }
            }
            System.out.println(profit);
        }
    }
}