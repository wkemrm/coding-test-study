import java.util.*;

class Main {
    static int n;
    
    public static void minus() {
        if (n - 3 >= 0) {
            n -= 3;
        } else {
            n -= 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int count = 2;
        String result = "SK";
        minus();
        while(n > 0) {
            if (count % 2 == 1) {
                result = "SK";
                minus();
                count++;
            } else {
                result = "CY";
                minus();
                count++;
            }
        }
        System.out.print(result);
    }
}