package back;

import java.util.*;

public class find {
	static int[][] map;
	static boolean[] c;
	static int n;
	static int[][] ans;
	
	public static void dfs(int x, int y) {
		c[y] = true;
		// x에 y로 이동하는 경로가 존재.
		ans[x][y] = 1;
		
		for(int i = 0; i < n; i++) {
			if(map[y][i] == 1 && c[i] == false) {
				dfs(x, i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		ans = new int[n][n];
		c = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			// i 마다 경로를 탐색해야하므로 방문한 노드 초기화
			for(int j = 0; j < n; j++) {
				c[j] = false;
			}
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && c[j] == false) {
					dfs(i, j);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}