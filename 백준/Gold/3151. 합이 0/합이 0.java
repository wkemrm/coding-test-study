import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        long result = 0;
        
        for (int i = 0 ; i < n - 2 ; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int lVal = arr[left];
                int rVal = arr[right];
                int sum = arr[i] + lVal + rVal;
                
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    if (lVal == rVal) {
                        long count = right - left + 1;
                        result += count * (count - 1) / 2;
                        break;
                    } else {
                        long firstCount = 0;
                        long secondCount = 0;
                    
                        while (left < right && arr[left] == lVal) {
                            firstCount++;
                            left++;
                        }
                    
                        while(right >= left && arr[right] == rVal) {
                            secondCount++;
                            right--;
                        }
                        result += firstCount * secondCount;
                    }
                }
            }
        }
        System.out.print(result);
    }
}