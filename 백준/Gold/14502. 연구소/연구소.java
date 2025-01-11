

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int[][] map;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static int result = Integer.MIN_VALUE;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		
		}
		DFS(0);
		System.out.println(result);
	}
	
	public static void DFS(int depth) {
		if (depth == 3) {
			BFS();
			return;
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void BFS() {
		int[][] copyMap = new int[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if(copyMap[i][j] == 2) {
					queue.add(new int[] {i ,j});
				}
			}
		}
		
		while(queue.size() != 0) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			for (int i = 0 ; i < 4 ; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 2;
						queue.add(new int[] {nx, ny});
					}
				}
			}
			
		}
		safe(copyMap);
		
	}
	
	public static void safe(int[][] copyMap) {
		int sum = 0;
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if(copyMap[i][j] == 0) {
					sum++;
				}
			}
		}
		result = Math.max(result, sum);
	}

}
