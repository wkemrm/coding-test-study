import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            int testCase = sc.nextInt();
            int[] arr = new int[20];
            arr[0] = sc.nextInt();
            int lastPoint = 0;
            int count = 0;
            for (int k = 1 ; k < 20 ; k++) {
                int su = sc.nextInt();
                int maxIndex = -1;
                for (int j = 0 ; j < k ; j++) {
                    if (arr[j] > su) {
                        maxIndex = j;
                        break;
                    }
                }
                
                if (maxIndex == -1) {
                    arr[k] = su;
                    lastPoint = k;
                } else {
                    for (int j = lastPoint ; j >= maxIndex ; j--) {
                        arr[j + 1] = arr[j];
                        count++;
                    }
                    arr[maxIndex] = su;
                    lastPoint += 1;
                }
            }
            System.out.println(testCase + " " + count);
        }
    }
}