import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int hCount = 0;
        for (int i = 0 ; i < h ; i += (n + 1)) {
            hCount++;
        }

        int wCount = 0;
        for (int i = 0 ; i < w ; i+= (m + 1)) {
            wCount++;
        }
        System.out.print(hCount * wCount);
    }
}