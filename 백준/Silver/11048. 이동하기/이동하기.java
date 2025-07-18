

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
 	static int n;
 	static int m;
 	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		
		for (int i = 1 ; i < n + 1 ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1 ; j < m + 1 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 1 ; i < n + 1 ; i++) {
			for (int j = 1 ; j < m + 1 ; j++) {
				map[i][j] += Math.max(map[i][j - 1], Math.max(map[i - 1][j], map[i - 1][j - 1]));
			}
		}
		System.out.println(map[n][m]);
	}
 
}
