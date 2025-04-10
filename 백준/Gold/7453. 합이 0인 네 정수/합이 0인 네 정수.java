import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sumA = new int[n * n];
        int[] sumB = new int[n * n];
        
        int sumACount = 0;
        int sumBCount = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                sumA[sumACount++] = a[i] + b[j];
                sumB[sumBCount++] = c[i] + d[j];
            }
        }
        
        Arrays.sort(sumA);
        Arrays.sort(sumB);
        
        int aPoint = 0;
        int bPoint = sumB.length - 1;
        
        long result = 0;
        
        while (aPoint < n * n && bPoint >= 0) {
            int aVal = sumA[aPoint];
            int bVal = sumB[bPoint];
            int sum = aVal + bVal;
            
            if (sum > 0) {
                bPoint--;
            } else if (sum < 0){
                aPoint++;
                
            } else {
                long countA = 0;
                long countB = 0;
                
                while(aPoint < sumA.length && sumA[aPoint] == aVal) {
                    countA++;
                    aPoint++;
                }
                
                while (bPoint >= 0 && sumB[bPoint] == bVal) {
                    countB++;
                    bPoint--;
                }
                result += countA * countB;
            }
        }
        
        System.out.print(result);
    }
}