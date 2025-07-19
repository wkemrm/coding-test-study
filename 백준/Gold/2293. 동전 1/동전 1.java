

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
	static int[] dp = new int[100001];
 	static int n;
 	static int k;
 	static int[] money;
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		money = new int[n];
		
		for (int i = 0 ; i < n ; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		func(k);
	}
 	public static void func(int num) {
 		dp[0] = 1;
 		
 		for (int i = 0 ; i < n ; i++) {
 			for (int j = money[i]; j <= k ; j++) {
 				dp[j] += dp[j - money[i]];
 			}
 		}
 		
 		System.out.println(dp[num]);
 	}
	
}
