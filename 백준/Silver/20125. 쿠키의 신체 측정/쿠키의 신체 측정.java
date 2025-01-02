import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        sc.nextLine();

        for (int i = 0 ; i < n ; i++) {
            String s = sc.nextLine();
            for (int j = 0 ; j < s.length() ; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
        int simI = -1;
        int simJ = -1;
        boolean flag = false;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (flag) break;
                if (i - 1 >= 0 && i + 1 < n 
                    && arr[i - 1][j] == '*'
                    && arr[i][j] == '*'
                    && arr[i + 1][j] == '*') {
                    simI = i;
                    simJ = j;
                    flag = true;
                }
            }
        }
        
        int leftCount = 0;
        for (int j = simJ - 1 ; j >= 0 ; j--) {
            if (arr[simI][j] == '*') {
                leftCount++;
            } else {
                break;
            }
        }
        
        int rightCount = 0;
        for (int j = simJ + 1 ; j < n ; j++) {
            if (arr[simI][j] == '*') {
                rightCount++;
            } else {
                break;
            }
        }
        
        int huryCount = 0;
        for (int i = simI + 1 ; i < n ; i++) {
            if (arr[i][simJ] == '*') {
                huryCount++;
            } else {
                break;
            }
        }
        
        int leftLegCount = 0;
        for (int i = simI + huryCount + 1 ; i < n ; i++) {
            if (arr[i][simJ - 1] == '*') {
                leftLegCount++;
            } else {
                break;
            }
        }
        
        int rightLegCount = 0;
        for (int i = simI + huryCount + 1 ; i < n ; i++) {
            if (arr[i][simJ + 1] == '*') {
                rightLegCount++;
            } else {
                break;
            }
        }
        
        System.out.println((simI + 1) + " " + (simJ + 1));
         System.out.println(leftCount + " " + rightCount + " " + huryCount + " " + leftLegCount + " " + rightLegCount);
    }
}