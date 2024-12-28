import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int max = arr[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--) {
            if (arr[i] >= max) {
                max = max - 1;
                count += (arr[i] - max);
            } else {
                max = arr[i];
            }
        }
        
        System.out.print(count);
    }
}