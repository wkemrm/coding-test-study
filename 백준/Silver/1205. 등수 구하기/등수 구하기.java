import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jumsu = sc.nextInt();
        int p = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0 ; i < n ; i++) {
            score[i] = sc.nextInt();
        }
        
        if (n == p && score[score.length - 1] >= jumsu) {
            System.out.print(-1);
        } else {
            int rank = 1;
            for (int i = 0 ; i < n ; i++) {
                if (score[i] > jumsu) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.print(rank);
        }
        
    }
}