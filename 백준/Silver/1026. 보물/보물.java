import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        int result = 0;
        for (int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0 ; i < n ; i++) {
            b[i] = sc.nextInt();
        }
        
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for (int i = 0 ; i < n ; i++) {
            result += a[i] * b[i];
        }
        
        System.out.print(result);
    }
}