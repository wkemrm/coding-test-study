import java.util.*;

class Main {
    static int[] switchArr;
    static int n;
    public static void male(int num) {
        for (int i = num ; i <= n ; i += num) {
            if(switchArr[i] == 1) {
                switchArr[i] = 0;
            } else {
                switchArr[i] = 1;
            }
        }
    }
    
    public static void female(int num) {
        int lt = num;
        int rt = num;
        while (lt - 1 >= 1 && rt + 1 <= n && (switchArr[lt - 1] == switchArr[rt + 1])) {
            lt--;
            rt++;
        }
        
        if (lt == num && rt == num) {
            if(switchArr[num] == 1) {
                switchArr[num] = 0;
            } else {
                switchArr[num] = 1;
            }
        } else {
            for (int i = lt ; i <= rt ; i++) {
                if(switchArr[i] == 1) {
                    switchArr[i] = 0;
                } else {
                    switchArr[i] = 1;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        switchArr = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            switchArr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        for (int i = 0 ; i < m ; i++) {
            int sex = sc.nextInt();
            int num = sc.nextInt();
            switch(sex) {
                case 1: {
                    male(num);
                    break;
                }
                case 2: {
                    female(num);
                    break;
                }
            }
        }
        
        for (int i = 1 ; i <= n ; i++) {
            System.out.print(switchArr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}