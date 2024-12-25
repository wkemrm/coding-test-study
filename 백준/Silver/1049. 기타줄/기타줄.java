import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> packageSu = new ArrayList<Integer>();
        ArrayList<Integer> su = new ArrayList<Integer>();
        for (int i = 0 ; i < m ; i++) {
            packageSu.add(sc.nextInt());
            su.add(sc.nextInt());
        }
        int packageMin = Collections.min(packageSu);
        int suMin = Collections.min(su);
        int min = Math.min(((n / 6) + 1) * packageMin, suMin * n);
        min = Math.min(min, (n / 6) * packageMin + (n % 6) * suMin);
        System.out.println(min);
        
    }
}