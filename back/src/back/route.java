package back;

import java.io.*;
import java.util.*;



public class route {

	private static class Point implements Comparable<Point>{
	    int end;
	    int weight;

	    public Point(int end, int weight){this.end = end; this.weight = weight;}

	    @Override
	    public int compareTo(Point o) {
	        return weight - o.weight;
	    }
	}
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 200_000_000;
    static List<Point> list[];
    static int dist[];
    static boolean check[];
    static int n, v;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // 洹몃옒�봽 �젙蹂� ���옣�븷 list瑜� 珥덇린�솕�븳�떎.
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        dist = new int[n + 1];
        check = new boolean[n + 1];

        // 媛꾩꽑 �젙蹂� 珥덇린�솕
        for(int i = 0 ; i < v; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // list�뿉 graph�젙蹂� ���옣 list�쓽 index�뒗 異쒕컻�끂�뱶
            // element�뒗 �룄李⑸끂�뱶�� 媛�以묒튂瑜� ���옣�븳�떎.
            list[start].add(new Point(end, weight));
            // 臾대갑�뼢 洹몃옒�봽�씠誘�濡� 諛섎��룄 異붽��빐以��떎.
            list[end].add(new Point(start, weight));
        }

        // �븘�닔 �끂�뱶 珥덇린�솕
        st = new StringTokenizer(br.readLine());
        int require1 = Integer.parseInt(st.nextToken());
        int require2 = Integer.parseInt(st.nextToken());

        // ���씠 硫붿냼�뱶 �샇異�
        int answer = solve(require1, require2);
        bw.write(answer+ "\n");

        bw.close();
        br.close();
    }

    private static int solve(int required1, int required2){
        int result1 = 0;
        int result2 = 0;

        // 寃쎈줈1
        // 1 -> �븘�닔1 理쒕떒嫄곕━
        result1 += dijkstra(1, required1);
        // �븘�닔1 -> �븘�닔2 理쒕떒嫄곕━
        result1 += dijkstra(required1, required2);
        // �븘�닔2 -> n 理쒕떒嫄곕━
        result1 += dijkstra(required2, n);

        //寃쎈줈2
        // 1 -> �븘�닔2 理쒕떒嫄곕━
        result2 += dijkstra(1, required2);
        // �븘�닔2 -> �븘�닔1 理쒕떒嫄곕━
        result2 += dijkstra(required2, required1);
        // �븘�닔1 -> n 理쒕떒嫄곕━
        result2 += dijkstra(required1, n);

        // 寃쎈줈1 && 寃쎈줈2 -> 媛��뒗湲몄씠 �뾾�뒗 寃쎌슦
        if(result1 >= INF && result2 >= INF) return -1;
        else return Math.min(result1, result2);
    }

    private static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if(check[curNode] == true) continue;
            check[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;
                // 誘몃갑臾� && 湲곗〈�쓽 怨꾩궛�맂 嫄곕━蹂대떎 �깉濡쒖슫 嫄곕━媛� �옉�쓣 寃쎌슦
                if(check[nextNode] == false && dist[nextNode] > curWeight + nextWeight){
                    dist[nextNode] = curWeight + nextWeight;
                    queue.add(new Point(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
    }
}