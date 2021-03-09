package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class tomato0 {
	
	private static class Point{
	    int row, col;
	    public Point(int row, int col){this.row = row; this.col = col;}
	}
	
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][], m, n;
    static Queue<Point> queue = new LinkedList<>();
    // �긽�븯醫뚯슦瑜� �굹���궡湲� �쐞�븳 諛곗뿴
    static int xArr[] = {-1, 0, 1, 0}, yArr[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                // bfs瑜� �떆�옉�븯�뒗 �끂�뱶瑜� �걧�뿉 異붽�
                if(arr[i][j] == 1) queue.add(new Point(i, j));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 4; i++){
                // �긽�븯醫뚯슦濡� �넗留덊넗媛� �씡�쓣 �닔 �엳�뒗吏� �뿬遺� �솗�씤
                if(checkLocation(row + xArr[i], col + yArr[i])){
                    // �씡�� �넗留덊넗瑜� �걧�뿉 異붽�
                    queue.add(new Point(row + xArr[i],col + yArr[i]));
                    // �씡�� �넗留덊넗�쓽 媛� = �씠�쟾�뿉 �씡�� �넗留덊넗�쓽 媛� + 1
                    arr[row + xArr[i]][col + yArr[i]] = arr[row][col] + 1;
                }
            }
        }
        // 理쒕� 媛믪쓣 援ы븯湲� �쐞�븳 蹂��닔
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                // �븯�굹�씪�룄 �씡吏� �븡�� �넗留덊넗媛� �엳�떎硫� -1�쓣 諛섑솚
                if(arr[i][j] == 0) return -1;
                // �넗留덊넗媛� �씡�뒗�뜲 嫄몃━�뒗 �떆媛꾩쓣 援ы븿
                result = Math.max(result, arr[i][j]);
            }
        }
        // 理쒕� 媛믪씠 1�씠�씪硫� �썝�옒遺��꽣 紐⑤몢 �씡�뼱�엳�뿀�떎�뒗 寃�
        if(result == 1) return 0;
        // 理쒕� 媛� - 1 --> 嫄몃┛ �씪�닔
        return (result - 1);
    }

    private static boolean checkLocation(int row, int col) {
        // 二쇱뼱吏� 踰붿쐞 諛뽰씤吏� 寃��궗
        if(row < 1 || row > n || col < 1 || col > m) return false;
        // �븘吏� �씡吏� �븡�� �넗留덊넗�씪硫� true 諛섑솚
        if(arr[row][col] == 0) return true;
        // �씠誘� �씡�뼱�엳嫄곕굹 鍮� �옄由щ씪硫� false 諛섑븳
        return false;
    }
}