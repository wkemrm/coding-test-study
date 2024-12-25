import java.util.*;

class Main {
    public static boolean solv(int[] nArr, int v) {
        int lt = 0;
        int rt = nArr.length - 1;
        boolean result = false;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nArr[mid] == v) {
                result = true;
                break;
            }
            if (nArr[mid] < v) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            nArr[i] = sc.nextInt();
        }
        Arrays.sort(nArr);
        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0 ; i < m ; i++) {
            mArr[i] = sc.nextInt();
        }
        
        for (int i = 0 ; i < mArr.length ; i++) {
            System.out.println(solv(nArr, mArr[i]) ? 1 : 0);
        }
    }
}