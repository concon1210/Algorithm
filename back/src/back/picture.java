package back;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;

public class picture {

    static int[] x = {-1,1,0,0};
    static int[] y = {0,0,-1,1};
    static int a;
    static int b;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int tmp_square;
    static ArrayList<Integer> square = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = new int[]{1, 0 , -1, 0};
		int[] dy = new int[]{0, 1, 0, -1};
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		String[][] field = new String[nm[0]][nm[1]];
		boolean[][] visited = new boolean[nm[0]][nm[1]];
		for (int i=0; i<nm[0]; i++) field[i] = br.readLine().split(" ");
		int num=0, max=0;
		for (int i=0; i<nm[0]; i++){
			for (int j=0; j<nm[1]; j++){
				if (field[i][j].equals("0") || visited[i][j]) continue;
				num++;
				ArrayList<int[]> Q = new ArrayList<>();
				visited[i][j] = true;
				Q.add(new int[]{i, j});
				int area = 0;
				while (!Q.isEmpty()){
				area++;
				int[] cur = Q.remove(0);
				for (int dir = 0; dir<4; dir++){
					int nx = cur[1] + dx[dir];
					int ny = cur[0] + dy[dir];
					if (nx<0 || nx>=nm[1] || ny<0 || ny>=nm[0]) continue;
					if (visited[ny][nx] || !field[ny][nx].equals("1")) continue;
					visited[ny][nx] = true;
					Q.add(new int[]{ny, nx});
					}
				}
				max = Math.max(max, area);
				}
			}
		System.out.print(num+"\n"+max);
		}

	
}

